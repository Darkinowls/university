from PyQt5.QtWidgets import QFileDialog, QMessageBox
from pandas import DataFrame

import database_manager
from PandasModel import PandasModel
from QMessanger import QMessanger, METHODS
from database_manager import WEATHER_TABLE
from dataframe_manager import get_weather_api, check_for_filling_needed, WIND_DIRECTION_ID, locate_datetime_gaps, \
    fill_gaps_by_pad, fill_gaps_by_interpolation, WIND_SPEED, TEMPERATURE
from file_manager import read_excel_files
from gui.UiMainWindow import UiMainWindow
from message_formatter import data_gaps_located_message, rows_were_affected_message

WARNING = 'Warning'
NO_DATE_GAPS_FOUND = "No date gaps found"
LOCATED_IN_THE_TABLE = 'All the date gaps are located in the table'
INFORMATION = "Information"
SUCCESS = "Success"
ERROR = "Error"
NO_DATA_IN_THE_TABLE = "There is no data in the table"


class MainWindow(UiMainWindow):
    __filenames: list[str]
    __weather_api: DataFrame = None
    __marked_weather_api: DataFrame | None
    __messanger: QMessanger
    __need_padding: bool
    __no_date_gaps: bool

    def setupUi(self, MainWindow):
        UiMainWindow.setupUi(self, MainWindow)
        self.__messanger = QMessanger()
        self.button_import_files.clicked.connect(self.__import_excel_files)
        self.button_locate_gaps.clicked.connect(self.__locate_gaps)
        self.button_safe_db.clicked.connect(self.__safe_to_database)
        self.button_fill_gaps.clicked.connect(self.__fill_gaps)

    def __import_excel_files(self):
        options = QFileDialog.Options()
        self.__filenames, _ = QFileDialog.getOpenFileNames(self, "Open excel files", "",
                                                           "Excel Files (*.xlsx)", options=options)
        if not self.__filenames:
            return
        self.__weather_api = get_weather_api(read_excel_files(self.__filenames), self.__filenames)
        self.tableView.setModel(PandasModel(self.__weather_api))
        self.tableView.setColumnWidth(0, 200)
        self.tableView.setColumnWidth(1, 125)
        self.tableView.setColumnWidth(2, 150)
        self.tableView.setColumnWidth(3, 125)
        self.__need_padding = check_for_filling_needed(self.__weather_api, WIND_DIRECTION_ID)
        self.__marked_weather_api = None
        self.__no_date_gaps = False

    def __locate_gaps(self) -> int:

        self.__check_table_not_empty()

        if self.__no_date_gaps:
            return self.__messanger.show_message(NO_DATE_GAPS_FOUND, INFORMATION, QMessageBox.Information)
        if self.__marked_weather_api is not None:
            return self.__messanger.show_message(LOCATED_IN_THE_TABLE, INFORMATION, QMessageBox.Information)
        weather_marked, gap_info = locate_datetime_gaps(self.__weather_api)
        if gap_info:
            self.__weather_api = weather_marked
            self.__marked_weather_api = weather_marked
            self.__need_padding = True
            self.tableView.setModel(PandasModel(self.__weather_api))
            message = data_gaps_located_message(gap_info)
            return self.__messanger.show_message(message, SUCCESS, QMessageBox.Information)
        self.__no_date_gaps = True
        return self.__messanger.show_message(NO_DATE_GAPS_FOUND, INFORMATION, QMessageBox.Information)

    def __fill_gaps(self) -> int:
        if self.tableView.model() is None:
            return self.__messanger.show_message(NO_DATA_IN_THE_TABLE, ERROR, QMessageBox.Critical)
        self.__do_padding()
        self.__do_interpolation()

    def __do_padding(self):
        if self.__need_padding and self.__messanger.question_message_padding_data():
            self.__marked_weather_api = fill_gaps_by_pad(self.__weather_api, [WIND_DIRECTION_ID])
            self.tableView.setModel(PandasModel(self.__marked_weather_api))
            self.__need_padding = False

    def __do_interpolation(self) -> int:
        if self.__marked_weather_api is None:
            return self.__messanger.show_message('Date gaps are not located in the table', WARNING, QMessageBox.Warning)
        answer = self.__messanger.question_message_fill_method()
        if answer != QMessageBox.Ignore:
            self.__weather_api = fill_gaps_by_interpolation(self.__marked_weather_api, METHODS.get(answer),
                                                            [WIND_SPEED, TEMPERATURE])
            self.tableView.setModel(PandasModel(self.__weather_api))
        return answer

    def __safe_to_database(self) -> int:
        if self.tableView.model() is None:
            return self.__messanger.show_message(NO_DATA_IN_THE_TABLE, ERROR, QMessageBox.Critical)
        if not database_manager.database_table_empty(WEATHER_TABLE):
            response = self.__messanger.question_message_erase_data()
            if response == QMessageBox.Cancel:
                return QMessageBox.Cancel
        else:
            response: int = QMessageBox.No
        affected: int = database_manager.save_database_table(self.__weather_api, WEATHER_TABLE,
                                                             database_manager.APPEND if response == QMessageBox.No
                                            else database_manager.REPLACE)
        message = rows_were_affected_message(affected)
        return self.__messanger.show_message(message, SUCCESS, QMessageBox.Information)
