Reviewer: Zhehao Chang(u6613739)
Component: GameStageController.java
Author: Yue Zhang(u6797258)
 
Review Comments:
 
1. GameStageController.java: 34-44 it’s good to use fxml to arrange the layout. But it has some problem in naming because the usage of underlines, like in “gridPane_special” which could be renamed as “gridPaneSpecial”. But actually java don't have the properly name for UI. In .net, we always use label_xxx,btn_xxx to name a label or button.
 
2. GameStageController.java: 186-198 works properly.line 193-194 can be merge into one line like: rotate=(rotate+1)%8
 
3. GameStageController.java:240-279 has some duplication, add an new method (like: void putDiceTiles() )can reduce duplication.
 
4. GameStageController.java:344-406 could be more readable if add some comments
 
5. GameStageController.java:645-670 works properly.
 
6.Overall comments: I think the code can work properly in its latest version because all the known bugs have been fixed and we have test it several times and did not find any new bug.