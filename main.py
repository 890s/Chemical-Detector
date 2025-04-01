from SubstanceRecognizer import *
import tkinter as tk

substances = SubstanceRecognizer("physical_chemical_properties_of_organic_substances.csv").getSubstances()

print(substances[0].getValues())

