from PyQt5.QtWidgets import QMessageBox

from consts import METHODS


class QMessanger:
    __message_box: QMessageBox

    def __init__(self):
        self.__message_box = QMessageBox()

    def question_message_erase_data(self) -> int:
        self.__message_box.setIcon(QMessageBox.Question)
        self.__message_box.setText("Erase old data in the database?")
        self.__message_box.setWindowTitle('How to save?')
        self.__message_box.setStandardButtons(QMessageBox.Yes | QMessageBox.No | QMessageBox.Cancel)
        return self.__message_box.exec()

    def show_message(self, message: str, title: str, icon: int):
        self.__message_box.setStandardButtons(QMessageBox.Ok)
        self.__message_box.setIcon(icon)
        self.__message_box.setText(message)
        self.__message_box.setWindowTitle(title)
        print(f'{title}:', message)
        return self.__message_box.exec()

    def question_message_padding_data(self) -> bool:
        self.__message_box.setIcon(QMessageBox.Question)
        self.__message_box.setText("Use padding to fill wind direction gaps?")
        self.__message_box.setWindowTitle('Use padding?')
        self.__message_box.setStandardButtons(QMessageBox.Yes | QMessageBox.No)
        return self.__message_box.exec() == QMessageBox.Yes

    def question_message_fill_method(self) -> int:
        self.__message_box.setIcon(QMessageBox.Question)
        self.__message_box.setText("Choose method for data interpolation")
        self.__message_box.setWindowTitle('Method of interpolation')
        self.__message_box.setStandardButtons(QMessageBox.Ignore)
        custom_buttons = [self.__message_box.addButton(METHODS.get(num), num) for num in METHODS]
        result = self.__message_box.exec()
        [self.__message_box.removeButton(button) for button in custom_buttons]
        return result
