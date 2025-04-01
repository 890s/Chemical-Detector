from SubstanceRecognizer import *
import tkinter as tk
from tkinter import ttk

root = tk.Tk()
ttk.Label(root, text='Themed Label').pack()
root.geometry('300x250')
root.mainloop()

substances = SubstanceRecognizer("physical_chemical_properties_of_organic_substances.csv").getSubstances()

print(substances[0].getValues())

#use this: https://www.pythontutorial.net/tkinter/tkinter-label/
