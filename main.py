from SubstanceRecognizer import *
from Substance import *
import tkinter as tk
from tkinter import ttk

root = tk.Tk()
ttk.Label(root, text='Themed Label').pack()
root.geometry('300x250')
root.mainloop()

systemAI = SubstanceRecognizer("C:\\Users\\200448984\\PycharmProjects\\PythonProject\\physical_chemical_properties_of_organic_substances.csv")

substance = Substance(["","","70","","","","","","","","",""])
results = systemAI.findKMostSimilar(substance,10)
print(results)
