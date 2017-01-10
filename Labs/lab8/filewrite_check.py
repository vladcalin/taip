from mop import Watcher


def alert_write_after_close():
    print("Tried to write to file after closing")


watcher = Watcher({
    "events": {
        "open": "open",
        "close": "close",
        "write": "write",
        "read": "read"
    },
    "rules": {
        ("close", "write"): alert_write_after_close
    }
})


@watcher
class FileWriter(object):
    def __init__(self, file_path):
        self.fp = None
        self.file_path = file_path

    def open(self, flags="w"):
        self.fp = open(self.file_path, flags)

    def read(self, bytes):
        try:
            return self.fp.read(bytes)
        except:
            pass

    def write(self, buffer):
        try:
            self.fp.write(buffer)
        except:
            pass

    def close(self):
        try:
            self.fp.close()
        except:
            pass


if __name__ == '__main__':
    # unsafe demo
    file_writer = FileWriter("test.txt")
    file_writer.open()
    file_writer.close()
    file_writer.write("hello")
