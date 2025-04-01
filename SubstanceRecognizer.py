from Substance import Substance
class SubstanceRecognizer:

    def __init__(self, filepath):
        self.file = open(filepath, "r")
        self.substances = [Substance(line.strip().split(",")) for line in self.file]
        self.substances.pop(0)

    def getSubstances(self):
        return self.substances


