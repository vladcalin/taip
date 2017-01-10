import os
import random
from mop import Watcher


def alert_invalid_state():
    print("Invalid state!")


watcher = Watcher({
    "events": {
        "init_seed": "reinitialize_seed",
        "generate": "generate_sequence"
    },
    "rules": {
        ("generate", "generate"): alert_invalid_state
    }
})


@watcher
class SecureNumberGenerator(object):
    def __init__(self):
        self.random = random.Random()

    def reinitialize_seed(self):
        self.random.seed(int.from_bytes(os.urandom(1024), byteorder='little'))

    def generate_sequence(self, bits):
        to_return = self.random.randint(0, 2 ** bits)
        return to_return


if __name__ == '__main__':
    print("Demo safe state")
    generator = SecureNumberGenerator()
    generator.reinitialize_seed()
    number = generator.generate_sequence(1024)
    print(number)
    print("")

    print("Demo unsafe state")
    generator = SecureNumberGenerator()
    generator.reinitialize_seed()
    number = generator.generate_sequence(1024)
    print(number)
    number2 = generator.generate_sequence(1024)
    print(number2)
    print("")
