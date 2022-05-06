import sys

from PySide2.QtCore import QUrl
from PySide2.QtWebEngineWidgets import QWebEngineView
from PySide2.QtWidgets import QApplication, QMainWindow


class MYAPP(QMainWindow):
    def __init__(self):
        super(MYAPP, self).__init__()
        self.webEngineView = QWebEngineView(self)
        self.setCentralWidget(self.webEngineView)
        url = QUrl.fromUserInput("https://wiseplat.github.io/test_www/")
        self.webEngineView.setUrl(url)
        if url.isValid():
            print(url)
            self.webEngineView.load(url)


if __name__ == '__main__':
    app = QApplication(sys.argv)
    ex = MYAPP()
    ex.resize(1024, 768)
    ex.setWindowTitle("My WWW")
    ex.show()
    sys.exit(app.exec_())