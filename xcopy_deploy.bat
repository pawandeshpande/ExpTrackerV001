@echo OFF 

echo Update all the classes 
xcopy t:\classes\com D:\OC4J\j2ee\home\applications\ExpTracker\ExpWeb\com  /D /S /Y /U 

echo Update all the public_html files
xcopy t:\public_html D:\OC4J\j2ee\home\applications\ExpTracker\ExpWeb  /D /S /Y /U


