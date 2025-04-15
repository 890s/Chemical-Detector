from Substance import Substance
class SubstanceRecognizer:

    def __init__(self, filepath):
        self.file = open(filepath, "r")
        self.substances = [Substance(line.strip().split(",")) for line in self.file]
        self.substances.pop(0)

    def getSubstances(self):
        return self.substances

    def findSimilarity(self, sub1, sub2):
        count = 0
        num = 0
        for i in range(2,len(sub1.getValues())):
            if (sub1[i]=="" or sub2[i]==""):
                continue
            elif (sub1[i]==sub2[i]):
                count += 1

            num += 1

        return count/num

    def findMostSimilar(self, sub):
        maxSimilarity = 0
        prediction = ""
        for substance in self.substances:
            if (self.findSimilarity(sub,substance)>max):
                maxSimilarity = self.findSimilarity(sub, substance)
                prediction = sub.getName()

        return (prediction, maxSimilarity)

    def nameToSubstance(self, name):
        for substance in self.substances:
            if (name==substance.getName()):
                return substance

    def findKMostSimilar(self, sub, k):
        substancesBackup = self.substances
        predictions = []
        for i in range(k):
            pred = self.findMostSimilar(sub)[0]
            self.substances = self.substances.remove(self.nameToSubstance(pred))
            predictions.append(pred)
            
        self.substances = substancesBackup
        return predictions
