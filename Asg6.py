import os
import wx
from collections import Counter

class  FrequencyPanel(wx.Panel):
    listOfWords=[]
    def __init__(self, parent):
        wx.Panel.__init__(self, parent)

        btn = wx.Button(self, label='Open Text File To Check Frequency of the words')
        btn.Bind(wx.EVT_BUTTON, self.onOpen)
        h_sizer = wx.BoxSizer(wx.HORIZONTAL)
        sizer = wx.BoxSizer(wx.VERTICAL)
        h_sizer.Add(btn, 0, wx.CENTER)
        sizer.Add((0,0), 1, wx.EXPAND)
        sizer.Add(h_sizer, 0, wx.CENTER)
        sizer.Add((0,0), 1, wx.EXPAND)
       

        self.SetSizer(sizer)

    def onOpen(self, event):
        filesupport = "TXT files (*.txt)|*.txt"
        dialogBox = wx.FileDialog(self, "Open Text Files", wildcard=filesupport,
                               style=wx.FD_OPEN | wx.FD_FILE_MUST_EXIST)

        if dialogBox.ShowModal() == wx.ID_CANCEL:
            return

        path = dialogBox.GetPath()

        if os.path.exists(path):
            with open(path) as fobj:
                for line in fobj:
                    self.words=(line.split());
                    for w in self.words:
                        self.listOfWords.append(w);

    
        self.listOfWords=Counter(self.listOfWords);
        no_frequent=3;
        str1=str(self.listOfWords.most_common(no_frequent)[0][0])+" : "+str(self.listOfWords.most_common(no_frequent)[0][1])
        str2=str(self.listOfWords.most_common(no_frequent)[1][0])+" : "+str(self.listOfWords.most_common(no_frequent)[1][1])
        str3=str(self.listOfWords.most_common(no_frequent)[2][0])+" : "+str(self.listOfWords.most_common(no_frequent)[2][1])
        
        dlg = wx.RichMessageDialog(self, "Top three most detected words : \n"+str(str1)+"\n"+str(str2)+"\n"+str(str3))
        dlg.ShowModal() 
        self.listOfWords=[]


class MainFrame(wx.Frame):
    def __init__(self):
        wx.Frame.__init__(self, None, title="Count the frequency of the words")
        obj = FrequencyPanel(self)
        self.Show()

if __name__ == '__main__':
    application = wx.App(False)
    maineframe = MainFrame()
    application.MainLoop()