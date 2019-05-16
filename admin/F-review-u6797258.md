Reviewer: Yue Zhang (u6797258)
Component: <...>
Author: Mirhady Dorodjatun (u6474009)

Review Comments:


1.	GameStageController.java: Although the code is newly written at the moment, it would be better to add some more javadoc and comments later on for more readability.
2.	GameStageController.java 417-548: It is good to have separation between methods that only change the display/GUI part and methods that change the underlying Board class. However, it would be better to separate these display/GUI methods to a separate place, for example the GuiUtil.java.
3.	GameStageController.java 528-552: The method name displayPlayerBoard implies that it would only handle the display part. However, it also includes placing new tiles on Board Class if the player type is AI. It may be better to separate this later.
4.	GameStageController.java: There were some bugs before but by now all of found bugs are fixed.