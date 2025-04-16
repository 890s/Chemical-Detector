class Substance:
    def __init__(self, list):
        for i in [0,1,5,6,7,8,9,10,11,12,15,16]:
            if list[i]=="" and i in [5,6,7,8,9,10,11,12]:
                list[i]=-9999999
        self.name = list[0]
        self.formula = list[1]
        self.molecular_weight = float(list[5])
        self.melting_point = float(list[6])
        self.boiling_point = float(list[7])
        self.heat_fusion = float(list[8])
        self.heat_vaporization = float(list[9])
        self.crit_temp = float(list[10])
        self.crit_pressure = float(list[11])
        self.flash_point = float(list[12])
        self.kingdom = list[15]
        self.superclass = list[16]

    def getValues(self):
        return [self.name, self.formula, self. molecular_weight, self.melting_point, self.boiling_point, self.heat_fusion, self.heat_vaporization, self.crit_temp, self.crit_pressure, self.flash_point, self.kingdom, self.superclass]
    def getName(self):
        return self.name
    def getFormula(self):
        return self.formula
    def getWeight(self):
        return self.molecular_weight
    def getMeltPoint(self):
        return self.melting_point
    def getBoilPoint(self):
        return self.boiling_point
    def getHeatFusion(self):
        return self.heat_fusion
    def getHeatVapor(self):
        return self.heat_vaporization
    def getCritTemp(self):
        return self.crit_temp
    def getCritPressure(self):
        return self.crit_pressure
    def getFlashPoint(self):
        return self.flash_point
    def getKingdom(self):
        return self.kingdom
    def getSuperclass(self):
        return self.superclass