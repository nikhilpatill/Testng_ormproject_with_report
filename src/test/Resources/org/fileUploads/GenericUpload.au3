WinWait("[CLASS:#32770]","",10)

ControlFocus("[CLASS:#32770]","","Edit1")

;ControlSetText("[CLASS:#32770]","","Edit1","C:\Acceleration\Current_Batches\AccelerationNew\Nov_23_Selenium\src\test\resources\org\fileUploads\SampleUpload.txt")

ControlSetText("[CLASS:#32770]","","Edit1",""&$CmdLine[1])

Sleep(2000)

ControlClick("[CLASS:#32770]","","Button1")