from SubstanceRecognizer import *
import tkinter as tk

substances = SubstanceRecognizer("C:\\Users\\200448984\\PycharmProjects\\PythonProject\\physical_chemical_properties_of_organic_substances.csv").getSubstances()

print(substances[0].getValues())

