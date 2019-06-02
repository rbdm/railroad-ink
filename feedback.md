# Assignment Two Feedback

## Group  thu15v
## Group members: "u6474009","Dorodjatun","Mirhady","","u6613739","Chang","Zhehao","","u6797258","Zhang","Yue"

## Tutor Comment

Code quality:

As I think has been a theme throughout the semester, I'm really impressed with your work and my feedback is all positive.

Fantastic work on your code structure, the use of folders to group classes is a great way to easily demonstrate the hierarchy. The additional and detailed junit tests are fantastic.

Great work on the consistent javadocs throughout the code base. 

Game:

The landing page and introductory setup is great. The game can be a little fiddly to play at times but the additional features more than make up for this.

Very impressed with your work.

Functionality:

Fantastic work on almost perfectly implementing all of the functionality. That's no small amount of work and you should all be proud.

For the one test you failed, it's a really minor bug in your code triggering the error.

The board string:
A3A10B2A31A1B30A0F61A4A21B1B14A4A41A4D61S2A50A5A63A2B01A1C02B0G52S0B63A0E63A2E51A4D51B0C32A5D31A5C61A0E41S5D41
has three special tiles.

In your code you count backwards from a specialTileLimit = 3, subtracting one for each tile found in the string. So in the case like above where the board string has 3 special tiles, the final count will be 0.

However your criteria to return false is when specialTileLimit <= 0, that equals 0 case means you're incorrectly returning false in cases such as this where there are 3 special tiles in the string.

## Mark

**  10.9/11.0**

## Miscellaneous marks

| Level | Requirement | Result |
|:-:|---|:-:|
||All files correct                     | .25/.25 |
||Authorship clear for all classes      | .25/.25 |
||Appropriate use of Git                | .5/.5  |
||Program runs from JAR                 | .25/.25 |
|P|Appropriate use of OO features       | .5/.5  |
|P|Presentation PDF complete            | .5/.5  |
|CR|Program well designed               | .5/.5  |
|CR|Comments clear and sufficient       | .5/.5  |
|CR|Coding style good                   | .25/.25 |
|CR|Appropriate use of JUnit tests      | .5/.5  |
|D|Design and code of very high quality | .25/.25 |
|D|Demonstrates interesting extensions  | .25/.25 |
|D|Works well and easy to run           | .25/.25 |
|HD|Game is exceptional                 | .5/.5  |

**Total for miscellaneous marks:**  5.25/5.25

## Game marks (manual)

| Level | Requirement | Result |
|:-:|---|:-:|
|CR|Tiles snap into place            | .25/.25 |
|CR|Tiles can be rotated and flipped | .25/.25 |
|CR|Only valid placements allowed    | .25/.25 |
|CR|Basic score at game end          | .25/.25 |
|D |Basic computer opponent          | .25/.25 |
|HD|Advanced computer opponent       | .5/.5  |

**Total for manual marks:** 1.75/1.75

## Test results

| Task | Test | Result | Marks |
|:-:|---|:-:|:-:|
| |Compiled|.25/.25|.25|
|2|IsTilePlacementWellFormed|3/3|.5|
|3|IsBoardStringWellFormed|6/6|.5|
|5|AreConnectedNeighbours|5/5|.5|
|6|IsValidPlacementSequence|4/5|.400|
|7|GenerateDiceRoll|4/4|.25|
|8|GetBasicScore|4/4|.5|
|10|GenerateMove|5/5|.5|
|12|GetAdvancedScore|2/2|.5|

**Total for tests:** 3.90/4.0

## Originality statements

#### Originality statement G
We declare that the work we have submitted for Stage G of this assignment and all stages before it is entirely our own work.

Signed: Mirhady Dorodjatun (uid: u6474009), Yue Zhang (uid: u6797258), Zhehao Chang (uid: u6613739)

#### Originality statement F
We declare that the work we have submitted for Stage F of this assignment and all stages before it is entirely our own work.

Signed: Mirhady Dorodjatun (uid: u6474009), Yue Zhang (uid: u6797258), Zhehao_Chang (uid: u6613739)

#### Originality statements E
I declare that the work I have submitted for Stage E of this assignment and all stages before it is entirely my own work, with the
following documented exceptions:

* The idea of <...> came from a discussion with <...>

* The code in class <...> uses an idea suggested by <...>

Signed: Mary Jones (u23445678)
I declare that the work I have submitted for Stage E of this assignment and all stages before it is entirely my own work.

Signed: Mirhady Dorodjatun (u6474009)I declare that the work I have submitted for Stage E of this assignment and all stages before it is entirely my own work.

Signed: Zhehao Chang (u6613739)
I declare that the work I have submitted for Stage E of this assignment and all stages before it is entirely my own work.

Signed: Yue Zhang (u6797258)

#### Originality statements D
I declare that the work I have submitted for Stage D of this assignment and all stages before it is entirely my own work, with the following documented exceptions:

* The idea of <...> came from a discussion with <...>

* The code in class <...> uses an idea suggested by <...>

Signed: Mary Jones (u23445678)
I declare that the work I have submitted for Stage D of this assignment and all stages before it is entirely my own work.

Signed: Mirhady Dorodjatun (u6474009)
I declare that the work I have submitted for Stage D of this assignment and all stages before it is entirely my own work.

Signed: Zhehao Chang (u6613739)
I declare that the work I have submitted for Stage D of this assignment and all stages before it is entirely my own work.

Signed: Yue Zhang (u6797258)

#### Originality statement C
We declare that the work we have submitted for Stage B of this assignment and all stages before it is entirely our own work.

Signed: Mirhady Dorodjatun (uid: u6474009), Yue Zhang (uid: u6797258), Zhehao_Chang (uid: u6613739)

#### Originality statement B
We declare that the work we have submitted for Stage B of this assignment and all stages before it is entirely our own work.

Signed: Mirhady Dorodjatun (uid: u6474009), Yue Zhang (uid: u6797258), Zhehao_Chang (uid: u6613739)

## Git Log
```
commit 33ef11dd50319bf8c02a0e9a6c2d9fd81f81540e
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Fri May 24 10:42:11 2019 +1000

    Updates G-features, gameStageController, best code statement

commit 45da6d8d4688354b4e87165a7961353fb4538fb9
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Fri May 24 10:39:11 2019 +1000

    Updates G-features

commit b18fd42ecb5c83b4c13bbd25896e1c94df4079b4
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Thu May 23 23:48:05 2019 +1000

    add initial bestScore.txt

commit 53ff15b4c28d21afdce267f3b536502ac1846a30
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Thu May 23 23:15:44 2019 +1000

    add junit test

commit dff8946d0d0904e2df95fcbe19280eb0e078a310
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Thu May 23 20:37:54 2019 +1000

    modified G-features

commit b6986c44f8156c7ad0d1fb91a3a8641d6b2c77e5
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Thu May 23 20:12:55 2019 +1000

    modified G-features

commit 549c135a6884740386245584c19f34704407cb64
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Thu May 23 20:10:17 2019 +1000

    add G-best-u6797258 and some authorship

commit e7b9ea0e6ae6eb969156a77d4292b9b24afabaae
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Thu May 23 18:21:44 2019 +1000

    update G-features

commit 6475e29fdb98c208e66f0238272ec29e5470e81e
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Thu May 23 15:15:19 2019 +1000

    add G-best-u6797258 and some authorship

commit 8e51e2b86a2acc942b5adca97cb41a2861e7f032
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Thu May 23 14:03:12 2019 +1000

    update G-features

commit 45dfe585266f8f79b392f272b9bddbf3e29085d4
Author: u6613739 <zhehao.chang@anu.edu.au>
Date:   Thu May 23 12:59:13 2019 +1000

    test game.jar success

commit 3ffba034dae18f2395cd3b3148ee3c66f83b6370
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Thu May 23 12:12:15 2019 +1000

    add presentation.pdf

commit 7b0ced6afe75d0cd5de836339d2c571b8342ed52
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Thu May 23 12:08:41 2019 +1000

    upload the best code of u6613739

commit 5c04096794e649c3766c2228ec89e105ef917ac3
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Thu May 23 11:06:40 2019 +1000

    update the order of top 5 score

commit c7e793ab69f7485892659061d3b13843be269ddd
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Thu May 23 10:28:17 2019 +1000

    update G-originality and G-contribution

commit cfc21217881449e5df2b4ccbc59782dc09be4b95
Author: u6613739 <zhehao.chang@anu.edu.au>
Date:   Thu May 16 15:07:18 2019 +1000

    update game.jar

commit bfdc0bdf6ebdbfa2e5217b7a2fb3a0ea0a940bc6
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Thu May 16 13:51:00 2019 +1000

    clean checkstyle

commit b8e8f70bde86034e4f741670b7dd6bf958030aa9
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Thu May 16 13:24:41 2019 +1000

    Added code review file for D2F

commit d27efa0d96cf6e3ab61afec0b9431c2afccf1382
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Thu May 16 13:13:05 2019 +1000

    Added code review file for D2F

commit 8f059d684e685b2f0bc37367fc79183e2bdcc6e6
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Thu May 16 12:59:37 2019 +1000

    amend a typo

commit b3fcea674ce4018124cffa31cbb145cfcc458500
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Wed May 15 23:33:15 2019 +1000

    amend a typo

commit 1cae7c1ea220c3c9a7584a56794fd2efdf17bcad
Merge: cabdd07 877a408
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Wed May 15 23:28:29 2019 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6474009/comp1110-ass2-thu15v

commit 877a408304a105379f1fecd6817338728095e2b0
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Wed May 15 23:26:16 2019 +1000

    F-review-u6613739

commit cabdd072f7e95cee0daa9d002e6acba5fd6f0f04
Merge: a8f2ae0 01c026f
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Wed May 15 21:58:23 2019 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #	game.jar

commit 01c026fdd358333ea0f554fcec43bb236c7a0e9d
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Wed May 15 21:55:24 2019 +1000

    clean checkstyle

commit 65b1f33e89b0ed7d64d81f8b31f76dce2904d930
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Wed May 15 21:33:06 2019 +1000

    update easy bot

commit 59f17a9d0e2bab94f93f10c244ab9056ae0cb315
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Wed May 15 21:31:08 2019 +1000

    update highestScore

commit a8f2ae04d520f9fb2511df5d28d3b489fd8871cc
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Wed May 15 21:10:06 2019 +1000

    add javadoc

commit 9cf36487a72bfa3710691eca3e3f848f8e9f1b09
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Wed May 15 20:54:52 2019 +1000

    add javadoc

commit 5b0752e5885d31e7884b757a6f7adbf6a5a2abd5
Author: u6613739 <zhehao.chang@anu.edu.au>
Date:   Wed May 15 17:39:20 2019 +1000

    update the originality and contribution of D2F

commit f2ff3dfb8ec29e97c9db3449eb479d6980c0011e
Author: u6613739 <zhehao.chang@anu.edu.au>
Date:   Wed May 15 17:36:41 2019 +1000

    push the game.jar to git

commit 5e595d41ced4e0c84f9585748febd4e45579b25c
Author: u6613739 <zhehao.chang@anu.edu.au>
Date:   Wed May 15 17:20:30 2019 +1000

    fix the UI label for lab computer

commit fe9784d8d95458f00d3cd38bbb461633adaed2c7
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Wed May 15 12:05:42 2019 +1000

    Change square size for unplaced square, to make it display the grid lines when unplaced

commit 4a7e0a6cb7a25ad53365c501ab30eff7b1a07631
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Wed May 15 11:24:28 2019 +1000

    fix problem when use takeback btn

commit 1129812da480906cd2256f250ceebc4ca6a5a5a6
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Wed May 15 10:37:52 2019 +1000

    Fixes a bug where the isAbleToMove not updating when the player put special tile last

commit 8030fc4c4bba778512da73300b339ddc12b127a7
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Wed May 15 02:52:23 2019 +1000

    Fixed a bug where special tiles' display are "stacking" if not used

commit e62ac75928edcc158e575cab5498a43e195118d4
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Wed May 15 02:38:03 2019 +1000

    Disable take back button for AI, added bonus area indicator to board, set gridpane color, add player type indicator

commit a1eb7ff4c34d15213ba203de875eb6e24994cfe9
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Wed May 15 01:01:53 2019 +1000

    Added getCurrentPlayer method and fixes a placement bug

commit f18ed5b51a99ea4ed101699a168228a1ebb20c47
Merge: 5fc45ff b548195
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Wed May 15 01:01:26 2019 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #	src/comp1110/ass2/controller/GameStageController.java

commit 5fc45fffbb2743f859ae044461c5b596b6c11ca5
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Wed May 15 00:56:04 2019 +1000

    Added getCurrentPlayer method and fixes a placement bug

commit b5481951f7ae703927e2d5ffd4716a2efa46fbbd
Merge: 28b78ef 3a902ad
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Tue May 14 17:58:47 2019 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6474009/comp1110-ass2-thu15v

commit 28b78efa9cb3c44acace0ba868175de05ec232de
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Tue May 14 17:58:25 2019 +1000

    fix problem when use takeback btn

commit 3a902adf278e44d06494898548633b7948a7afbd
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Tue May 14 16:37:20 2019 +1000

    change title of windows

commit 5526f0cbeb8c786f056be2a0901f798543bc99fa
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Tue May 14 16:28:57 2019 +1000

    sp is 3 for AI

commit 1edf57e007aab84c2bd06a1a5fd6d345fb9227a9
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Tue May 14 16:13:57 2019 +1000

    fix problem when first player is AI

commit 09625b96fbc3dd4c242ce282ff85237246c891f6
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Tue May 14 15:00:27 2019 +1000

    change diceroll method

commit 33b1a7428bae27ce3d3b61ea4bbb5970d3ce9032
Merge: 46748a5 342225c
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Tue May 14 14:53:15 2019 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6474009/comp1110-ass2-thu15v

commit 46748a580d94222179fcde83657c759608bb4fc0
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Tue May 14 14:52:45 2019 +1000

    fix the special tiles bug

commit 342225c57509238852b7c3de929fc017208a2f7b
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Tue May 14 14:46:58 2019 +1000

    update the AI use unsame SP

commit 082cf19b990f45c3bcc82128d038bf292b6788a3
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Tue May 14 14:31:02 2019 +1000

    rename gameStage as GameStageController

commit 791c097c974d421ad7f3eaffb08bea54592a4edd
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Mon May 13 23:44:28 2019 +1000

    rename gameStage as GameStageController

commit 5e9d3bdd3c311ead0221f874d3dd9c47f4382855
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Mon May 13 23:28:52 2019 +1000

    fix the bug made just now

commit 3198b196471832c57117eb747ca58ccdea6fc95b
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Mon May 13 23:11:48 2019 +1000

    fix the bug and the Special Tile can not use more than 3 now.

commit 42656fd29e40b8790910d491bd0ef3492103c4cb
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Mon May 13 23:00:05 2019 +1000

    fix the bug and the Special Tile can not use more than 3 now.

commit a8711c110649877904590d323d500e5efacb8698
Merge: 7e68b4e 67a3a5a
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Mon May 13 20:39:09 2019 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #	src/guidemo/GameStage.java

commit 7e68b4e7c9f268c9aa3742a73c241080c7383c81
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Mon May 13 20:16:23 2019 +1000

    -Add functionality so when player can't make move with regular tile, player can click end turn. -Fixes warning message to be more appropriate in more situations.

commit 67a3a5a21613bafa422b6371f3acf8376b6eeebd
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Mon May 13 19:00:05 2019 +1000

    clean checkstyle

commit cc17e698ec479f29d27790231816eec95254de2a
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Mon May 13 18:59:08 2019 +1000

    clean checkstyle

commit d6cbda30d8c91498d7f4262c32d6069ef2b5a838
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Mon May 13 18:38:00 2019 +1000

    update socre form

commit 67dca11bec9b04f187bdd9a33686412cb00d0459
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Mon May 13 17:16:49 2019 +1000

    Fixes a bug where special tiles are 'stacking' their display if not used

commit 520997f140ec3f3c5ff044f352cc93e365295a1b
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Mon May 13 17:14:53 2019 +1000

    Fixes a bug where AI won't move on round 2+ if made as the only player

commit 096a343cc3b2f23ddab361a9576f59e8988f4095
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Mon May 13 16:54:20 2019 +1000

    -Fixed a bug where AI won't move if made into player 1, Fixed a bug where grids disappear after AI moves, Refactor class name in GameStage

commit 6587892785e812eb4fa254c270146ab5abbdc652
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Mon May 13 15:57:04 2019 +1000

    updatePlayerUsedSp

commit fbeb1d0986c4785594c06d15f38890d73147ad96
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Mon May 13 15:55:30 2019 +1000

    edit the game stage

commit f927c54ea05f4a663595543dbcaea2651a832a15
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Mon May 13 15:45:00 2019 +1000

    edit the game stage

commit 0e90e88adf25a1958c40867d305c561088e065bd
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Mon May 13 15:27:09 2019 +1000

    finish show AI in UI

commit 0399349824399adc7c03c9298587e4a5f953c834
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Mon May 13 14:25:02 2019 +1000

    finish greedy algorithm with softmax

commit 23c2326fcd62f7f02a4e329613a2c2e8730e3740
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sun May 12 12:17:35 2019 +1000

    Fixes a bug where the gridPane doesn't display the grids after some actions

commit 136f833d4b423348013d1a4bf262f726d1a94e0c
Merge: 41b19c1 376247d
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Sun May 12 12:03:20 2019 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6474009/comp1110-ass2-thu15v

commit 41b19c1a45e1df4552d50750478945593d62cab7
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Sun May 12 12:03:08 2019 +1000

    the game stage can hide when the 7th round finished

commit 376247d5fa7c8d5bbfecc96d03b550810b1784d0
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sun May 12 11:59:32 2019 +1000

    Fixes warning message when rotating tiles

commit 6045ac9e006e25a6382115dec8bf5e27556963e4
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sun May 12 11:47:21 2019 +1000

    added reset special tile count after take back

commit 2a237560f91b1f8311148f8a8a2fe635f7289ab4
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sun May 12 11:26:59 2019 +1000

    Removes sout messages

commit bcbfbb82c0128a073df05668fcf11aa2cc4f8e5b
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sun May 12 11:23:55 2019 +1000

    Added method removeBoardStringFromBoard

commit 7643e23b65347de9fdd830fda0a74b6f88b7d27d
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sun May 12 11:22:51 2019 +1000

    Fixed take back button for the board part

commit f52a4eb24f1033a481ac12015a874a3268de5601
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sun May 12 10:50:22 2019 +1000

    Added some getter/setter in Player model

commit 63fb7cf77a0de74e1509259fe17e75fd4c1a674b
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sun May 12 10:48:54 2019 +1000

    Added take back button

commit e7b03255e77e0f066e39903425723bff6e6aa044
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sun May 12 10:48:02 2019 +1000

    Added take back button

commit 3cfcfb319a24db349ea8562f39f395c106b71ef6
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sun May 12 10:47:40 2019 +1000

    Added methods for displaying specific player's board

commit 1d06f2adcddaaf7f59b03f772a2af714871232d8
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sun May 12 10:44:33 2019 +1000

    Added save & load for every player, involving board, boardString, and board display. Todo: take back button

commit 19d1bb4eb460bf881f626550723378f6208b312b
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Sat May 11 21:55:12 2019 +1000

    the game stage can hide when the 7th round finished

commit 88bee261248e3e613d7c6f9d2d164aba53423b5e
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Sat May 11 21:41:53 2019 +1000

    fix the problem about rule

commit 899b74e0527b1151dae4ca1c70dd2a7eb778dcc0
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Sat May 11 20:39:47 2019 +1000

    fix the problem in setDiceRoll

commit 56e0aac69f1e20385e1595ab408ecee362e4c14b
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sat May 11 17:49:15 2019 +1000

    Added warning for invalid placement

commit 0a017f30bcb54fc4bc03408ff9f34b14ae6bde3f
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sat May 11 16:20:28 2019 +1000

    fixed some typos

commit 8d9c4d64f771b3982aaf31957a2110f6b507f294
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Sat May 11 16:13:27 2019 +1000

    set the two gridpanes to front

commit b76f4f8cb181c5ca624b9668cb6851d2f4440651
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sat May 11 15:27:15 2019 +1000

    added getBoardSquareNameFromPosition method

commit 66cf454acc66a2a2eb11f7369e2e36f860074eec
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sat May 11 15:26:45 2019 +1000

    Added drag tile to board method and display initial board method

commit f14f5a832de3643ff8968255e046f5b37a69fc8a
Merge: 7b3dcb8 d806331
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Fri May 10 19:22:50 2019 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6474009/comp1110-ass2

commit d80633114f86e05b75b98ea7c458de48ab392dca
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Fri May 10 14:11:30 2019 +1000

    change all png to jpg

commit 7b3dcb828acf6a2ba58149cd546bcb7af146475b
Merge: 85b3317 5cc4487
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Fri May 10 12:50:46 2019 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 85b331739e7e761830a0fcef803950e5f7c0c47b
Merge: 7a67eab 187bc1e
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Thu May 9 14:29:47 2019 +1000

    Merge remote-tracking branch 'origin/master'

commit 7a67eab5d9df55c712f16052d52908af382ad553
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Thu May 9 14:29:15 2019 +1000

    add test and originality.md

commit 187bc1ed74b8b4e48b5bbe06b90aeadf4ccace70
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Thu May 9 13:56:31 2019 +1000

    Added more input for getPossibleDicePlacementTest

commit c3fb7ecdb6e0c83e28a3051139dc45d0b1aeeed8
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Thu May 9 13:47:31 2019 +1000

    Updated javadoc of getPossibleDicePlacementTest

commit cfd231d00ab49b75bfcab7d348cf371ae8cbb4e9
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Thu May 9 13:44:51 2019 +1000

    Added javadoc for getPossibleDicePlacementTest

commit b43fd8e9622ada163dac9ffab5f78d356d4aa3b7
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Thu May 9 13:41:15 2019 +1000

    Updated getPossibleDicePlacement for illegal input

commit 210bd8d6dda874ee9efa9efa4388e1893078a00a
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Thu May 9 13:39:23 2019 +1000

    Added JUnit Test for getPossibleDicePlacement

commit 0ed97bac7584f4d631a41827dae36b27609acf34
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Thu May 9 12:57:45 2019 +1000

    Moved custom test to a new u6474009 package

commit a0dffc6031a4928b3879f26204472977d2cda532
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Thu May 9 12:55:40 2019 +1000

    Moved moreTask10Test to a new JUnit Test class

commit 0233ab8d3b16c01fee7e97391b744fc5397d58e6
Merge: be812eb 4209338
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Thu May 9 12:52:23 2019 +1000

    Merge remote-tracking branch 'origin/master'

commit be812eb14fa7f8bb18a9c223475db026efd61a36
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Thu May 9 12:52:17 2019 +1000

    Moved moreTask10Test to a new JUnit Test class

commit 4209338f4b1e0bdc808992d7f2cdabb81b4af748
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Thu May 9 12:48:34 2019 +1000

    GreedyTest update CanNotPutTest

commit 199700051df6055dca42aafc520e09e0e53305d9
Merge: 294030b a540179
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Thu May 9 12:36:28 2019 +1000

    Merge remote-tracking branch 'origin/master'

commit 294030bdf59e69c060cb45547dfe8bf03a791d2e
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Thu May 9 12:36:10 2019 +1000

    update originality and GreedyTest

commit a5401792b03f59bdaaf610408454b50c164843ae
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Thu May 9 12:21:06 2019 +1000

    Updated originality statement for D2E

commit b5d1faa6cabc444cdf2dc6499f533889ba10383b
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Thu May 9 12:20:23 2019 +1000

    Added more test for Task10

commit 5cc448733278de86218c9944959e10b73d690ea9
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Thu May 9 00:26:38 2019 +1000

    fix chi-squared test values

commit cabb6c1d62ed51b16fd1ab0294b8e21a61229d76
Merge: 32bd9e3 8363816
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Wed May 8 21:58:33 2019 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 83638167f37ebcc8b4ba7857a67b38c1857f9d47
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Wed May 8 09:51:54 2019 +1000

    improve GenerateDiceRollTest to be statistically more rigorous
    
    added more tests for invalid placements due to duplicates

commit f6998e646dc7b8d48abb21808d8c2acdf7141aae
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Wed May 8 08:19:25 2019 +1000

    isValidPlacementSequenceTest: fix and add test for invalid connection
    
    add test for duplicate placements

commit 32bd9e3b01080f0431f7d7a2dd0a3b33e7e512a5
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Tue May 7 17:00:10 2019 +1000

    finish greedy algorithm of a AI prototype

commit c6515fad85a528e4942a12c2ede2ae7afb481a2a
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Tue May 7 14:04:49 2019 +1000

    fix another problem in rotate method

commit 8148f8b1119417ad35c09304ae0049d910d937d9
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Tue May 7 13:47:52 2019 +1000

    fix a little problem in rotate method

commit f841c5713980202bc3020c93c01358b9f6aa73ef
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Tue May 7 00:03:21 2019 +1000

    edit gamestage AND tiles can rotate when right click

commit 4bee09aeea2c609393899e0b7b609d6998f32d7a
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Mon May 6 23:50:47 2019 +1000

    Optimization code

commit a59866fb35786a1f5eb1e529cdea6da38ff26b36
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Mon May 6 23:38:19 2019 +1000

    clean checkstyle

commit 19ef2b81c1a892a08c7f94223f9da4585b5b3c7b
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Mon May 6 23:27:33 2019 +1000

    edit gamestage AND tiles can rotate when click

commit f040a813f09bc511cea8fc5cd67a828817f69575
Merge: ed374e0 0e3d0aa
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Mon May 6 15:56:48 2019 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6474009/comp1110-ass2-thu15v

commit ed374e0934910a14613ca4324450731d919d5036
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Mon May 6 15:56:40 2019 +1000

    edit gamestage

commit 0e3d0aa21a8a3d9ff3f2f29d1328abca1f79350e
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Mon May 6 14:23:30 2019 +1000

    D2D JUnitTest

commit 20f94fc800715ea7183ddbd6f90ebc0fd31459b0
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Mon May 6 10:50:23 2019 +1000

    remove unused code

commit b953060a4dd8bf37489323395d6cff489c72ced8
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Mon May 6 10:49:17 2019 +1000

    fix GenerateDiceRollTest.testDieFaces to correctly count dice rolls

commit 0aebce6875c453c51220227ca70e877e29578cd8
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Sun May 5 21:13:44 2019 +1000

    add GameStage into guidemo

commit 2fb31de2169534f3ab8372c0a0f0fd07b1fdf0da
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Sun May 5 17:16:46 2019 +1000

    update OptionForm

commit ead7ff81488108d45d49821d456914d703e8e92a
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Sat May 4 21:56:36 2019 +1000

    add GameStage into guidemo

commit 1eab43e026008249bc0aae5016c005e79e8291c1
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Sat May 4 20:55:31 2019 +1000

    add GameStage into controller

commit ee2f3761c9e47d99538e1488ea1495a8e084e239
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Sat May 4 20:49:38 2019 +1000

    add gamestage.fxml

commit 317ca88c535b3ae175e746b56b3f4c5686db3221
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Sat May 4 16:40:42 2019 +1000

    update StartForm

commit c84ba525028f3300bc46064fceefa1158bd2eec6
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Sat May 4 16:27:45 2019 +1000

    fxml of OptionForm and StartForm

commit 78fd9f0990bf137a5347d01042b9f185aa3960dc
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Sat May 4 16:26:51 2019 +1000

    the StartForm and OptionForm of GUI

commit c5c50345e8c4f9a2cb77260cb57e3048855e01ef
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Fri May 3 19:41:58 2019 +1000

    a demo of using SceneBuilder

commit b19313c2d98a8606391362123f556466864417f6
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Thu May 2 11:31:04 2019 +1000

    created D-originality-u6797258

commit 28e50bd4f7422838001d5086652f2443e915d9ef
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Thu May 2 10:51:38 2019 +1000

    Updates originality statement for deliverables part D2D

commit 96b841099804f9ebf924120db4aaa27504f58b52
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Wed May 1 13:46:48 2019 +1000

    Updates originality statement for deliverables part D2D

commit b28b85eb71015c3b057c07977a9a324f90d5fbdd
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Tue Apr 30 14:06:34 2019 +1000

    refactor the GUI of Board

commit fb39b2ce5300aa68ecc61285083f567d80c999a4
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Fri Apr 26 15:41:14 2019 +1000

    update flow chart

commit a927ab5e107091db68d7035a56c275b06d69a106
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sun Apr 21 21:08:07 2019 +1000

    Changed method isEmptyPosition and isValidPosition to private

commit 160d9d9d6a1a54ccb5b25d85fbeedda09868cefd
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sun Apr 21 21:03:13 2019 +1000

    Changed variable name in method isValidBoardStringPlacement

commit 51723ae6245d7b065b677725192d925c5b4fa3b6
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sun Apr 21 20:52:35 2019 +1000

    Changed the way to judge isEmptyPosition, by using TypeSquare.EMPTY

commit 9909e7a9f083da05b8ee6487014f9b8ed6f90553
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sat Apr 20 08:19:44 2019 +1000

    Added methods used to solve task 10, and added 1 step (isEmptyPosition) to isValidPlacement

commit 355c8b90e9922740cbb6698ddc3a1cd203764440
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Sat Apr 20 08:16:18 2019 +1000

    Finish task 10 and updates task 6 to be more readable

commit b0f125b3c9b1c63d4ef3788e9d9269919735ddb3
Merge: eab48f1 4cedafd
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Fri Apr 19 17:04:13 2019 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6474009/comp1110-ass2

commit 4cedafdb64f8c4bba170e13a478880bb858173e2
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Fri Apr 12 16:11:19 2019 +1000

    update junit test

commit 3fcb1a039485f9a91e4ed94e55c9a31bd4f15e10
Merge: 0931413 9cee2b5
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Fri Apr 12 16:09:28 2019 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit eab48f119941fa1201b18b0b43d340cac7172304
Merge: 4b01151 0931413
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Wed Apr 3 22:31:28 2019 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6474009/comp1110-ass2

commit 4b011518a003c40313b43b7ba1c4070aa9e46e83
Merge: f19ce1c 9cee2b5
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Wed Apr 3 22:30:33 2019 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 0931413e8b4ad62be436c6454d7b0d3306610b89
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Wed Apr 3 14:52:08 2019 +1100

    refactor the GUIUtil class to easy controll the GUI

commit 0e5d8fc64fbe0118034a9cc9120b55d77583e415
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Wed Apr 3 14:39:23 2019 +1100

    edit ourtest

commit efcdba4e1e006f464268c8fbeba415ed8049edda
Merge: 4a7f1d1 8dfc7b3
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Wed Apr 3 14:27:41 2019 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6474009/comp1110-ass2-thu15v

commit 4a7f1d1ba5b853f606198897cc601c44048e3f84
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Wed Apr 3 14:27:28 2019 +1100

    add javadoc to ExitUtil

commit 6cfbee31a0c53579e7488974c1dda0e7570b5586
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Wed Apr 3 14:22:52 2019 +1100

    edit ExitUtil

commit 8dfc7b38318c902db75fc1e05cc2da08b5a80345
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Wed Apr 3 14:20:47 2019 +1100

    clean checkstyle of RouteUtil.java

commit c21a74061d9d5c11f8ba9b12c24a1794ccea2691
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Wed Apr 3 14:18:58 2019 +1100

    code optimization

commit d7fc5440bd8efb996405e8f4142a094b5c5548db
Merge: ae5e9b5 a26b465
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Wed Apr 3 14:03:01 2019 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6474009/comp1110-ass2-thu15v

commit ae5e9b5fd6736db0cd21d0d891f32ca6ba196efb
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Wed Apr 3 14:02:27 2019 +1100

    edit ExitUtil pass task8 test

commit ae811a9e56dd6f02028a4fc611e3ebed0efcb821
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Wed Apr 3 14:00:28 2019 +1100

    edit ExitUtil pass task8 test

commit a26b4655e901b421e124b750b6b46f8851a1a546
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Wed Apr 3 13:30:35 2019 +1100

    plus bonus and basic score.

commit be06387fa8d414a1d079c4f5456f9bc5a04a492b
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Wed Apr 3 12:38:24 2019 +1100

    edit ExitUtil pass task8 test

commit 4161073f945bcdf921e89f837f59df76124382c8
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Wed Apr 3 10:58:40 2019 +1100

    edit ExitUtil

commit 02934e293c0ed0e87e7883f70bce6c0a7df98905
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Wed Apr 3 00:12:00 2019 +1100

    add comment to ExitUtil

commit a53b02419c1ffe19a7b7ce164a9ed3eaeb668b8d
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Tue Apr 2 22:44:30 2019 +1100

    add comment to ExitUtil

commit 380a77b526652cfa35d93bf75673c74fd5fe0ea7
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Tue Apr 2 16:08:20 2019 +1100

    add comment to ExitUtil

commit a8f3244e1f7b4a454b0cd755709185ba48cbfb04
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Tue Apr 2 15:40:24 2019 +1100

    function for task 8 work in some situation but still get some problem.

commit 30b7b98abc481e06807e12954360ca7c8cfceb2e
Merge: be6f664 f19ce1c
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Tue Apr 2 11:57:08 2019 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6474009/comp1110-ass2-thu15v

commit be6f6640f5627b676afc6adff42b09b662a9797c
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Tue Apr 2 11:55:17 2019 +1100

    fixed allRoute

commit f19ce1c296bcd9f7ecda497f34e424174e79bd86
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Tue Apr 2 09:59:17 2019 +1100

    Updates admin files for Phase C

commit cd333010419d6e77d19b9e039fb60f8eff173d45
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Tue Apr 2 09:58:40 2019 +1100

    Minor update to task 3 and 6

commit 9cee2b5b00726f2f206ecd616012ddcc36018c90
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Apr 2 09:12:01 2019 +1100

    AreConnectedNeighboursTest: more tests for mirror-asymmetric tiles

commit 8bd8d55e64ae767db719c2c8ae3641f602ffc2fd
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Tue Apr 2 00:23:18 2019 +1100

    try to fix task8 (need to debug)

commit bd0fae0825896516b1fe30b03ce12ec700b1f1ff
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Tue Apr 2 00:22:51 2019 +1100

    try to fix task8 (need to debug)

commit 320f7c003004b3ce33e94aa8ac3d120455b91d57
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Mon Apr 1 18:59:30 2019 +1100

    modified putplacementtomap

commit f0a3595f10f29821f55bd3fb6a423d6abf8366ed
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Mon Apr 1 18:57:16 2019 +1100

    for task 8

commit de956e9ee871702a9acb62f5ed751f5efebe3798
Merge: c89cbb4 5aa00a7
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Mon Apr 1 14:12:39 2019 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6474009/comp1110-ass2-thu15v

commit c89cbb4fb333ada74a002b5081bd9e54c4370f83
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Mon Apr 1 14:12:27 2019 +1100

    create a class for task 8

commit 353ece2f4f4f890b48e56345b61e27958c7d9f2a
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Mon Apr 1 14:11:54 2019 +1100

    modified board to give exit positionpoint

commit 5aa00a71051237d4d6af4a801392bd61f9953a3d
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Mon Apr 1 12:52:38 2019 +1100

    add comments of RouteUtil

commit 9ae06a25871ac27b6d6d870b903aa57c768b7003
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Mon Apr 1 12:38:44 2019 +1100

    clean checkstyle

commit 9fee2e6c0338b1d5f2cfd6859fc7627a3f60eb86
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Mon Apr 1 12:31:12 2019 +1100

    fix javadoc

commit 0d2de090674af007a4dfc2fbd485b4c2ea72be9d
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Mon Apr 1 12:27:37 2019 +1100

    update junit test

commit a41fd48526329225b393df4bae2df74fe27946da
Merge: 64e9060 c31ba1e
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Mon Apr 1 12:09:13 2019 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 64e90600dad4e0413ab8c95b298779e27a854e28
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Sun Mar 31 19:13:42 2019 +1100

    update @Test
    change Test class to OurTest class

commit b3f1199bb13925424078fb66312851ab6da31ce0
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Sun Mar 31 19:05:06 2019 +1100

    task12 javadoc and checkstyle fixed

commit 3353dbabf01f9eab2d0737df2d97ad00112cefea
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Sun Mar 31 18:53:08 2019 +1100

    task12 fixed

commit e6fd937b84e9885d39a05e541e12e700af734283
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Sun Mar 31 18:30:56 2019 +1100

    task12 finish calculate longest route

commit c31ba1ef10ecf073353dddfbfd2bb72343c6c495
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Sun Mar 31 08:54:35 2019 +1100

    T10 GenerateMoveTest

commit 5a0302f1af1a21b7302a7be2b7061203f7531b48
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Sat Mar 30 22:39:34 2019 +1100

    T8 GetBasicScoreTest, T12 GetAdvancedScoreTest

commit d61559a8eace9eb0de8948899ccf1a333a7a43eb
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Sat Mar 30 14:39:59 2019 +1100

    test more types of invalid piece placements

commit 4a9e766f786cd34b54bbcac2a88997d59cd43fe7
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Fri Mar 29 13:24:17 2019 +1100

    edit test

commit c36d382c5f78a2a36dd4f96d26131802dae55370
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Fri Mar 29 13:13:31 2019 +1100

    fix isValidPlacement(Square square) (x=-1,y=-1)

commit def0f3f6b2a3464fb948462dc2c82e8e9afa41c3
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Thu Mar 28 16:19:19 2019 +1100

    fix isValidPlacement(Square square) (x=-1,y=-1)

commit 3841769f645581b9fbbbb79898eadcad1017f53b
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Thu Mar 28 14:24:33 2019 +1100

    fix isValidPlacement(Square square) (x=-1,y=-1)

commit 82de85e87077609614d60d971e00bb11d8dd1ce5
Merge: 67e82e3 a4fe383
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Thu Mar 28 12:30:41 2019 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6474009/comp1110-ass2

commit 67e82e3b2cc1508412edb4f1bea5c054eb718c91
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Thu Mar 28 12:30:12 2019 +1100

    done isValidPlacement(Square square)

commit a4fe38397121deb96b548a4bbf324bc8d248e23c
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Thu Mar 28 11:55:36 2019 +1100

    skeleton fix

commit 5c9f95339a8ac4ee863f672678a1b0e247922003
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Thu Mar 28 11:18:08 2019 +1100

    done task7

commit fa3545dc672c93b968f9655c3d7d96183175ed69
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Thu Mar 28 07:54:13 2019 +1100

    Added some skeletons that might be used in task 7 onwards

commit 58ef1cf430ee9d2839857c9918eb30a02815b876
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Tue Mar 26 19:00:31 2019 +1100

    Updated contribution and originality statement for phase B

commit cb20b7da5bcbd8be6344f09d43635d58cff3a558
Merge: 8fb7096 762288d
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Tue Mar 26 18:53:37 2019 +1100

    Merge remote-tracking branch 'origin/master'

commit 8fb7096020d0b19e37342f30369190f2bcc8b8e9
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Tue Mar 26 18:53:19 2019 +1100

    fix viewer

commit 762288d4697815faee2243c24de4b222197a53d6
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Tue Mar 26 08:13:00 2019 +1100

    Finish task 3 and 6

commit a065da98797f0c7d71039cb85de0a30f24830d5d
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Tue Mar 26 08:10:01 2019 +1100

    Add method isConnectedWithExit

commit 76e38f447b0463e4db1297236521e316c72cd57a
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Mon Mar 25 12:20:33 2019 +1100

    add javadoc of PositionPoint Square

commit f8117bae972cb409d0631661e08bba796edbc2c8
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Mon Mar 25 12:18:00 2019 +1100

    add javadoc of Board

commit ee951d10bbe32f1a0a771000471defb68001824a
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Sun Mar 24 22:42:39 2019 +1100

    finish task4

commit 6114d12e90ccaec5ef630fd2248e14fe86dae812
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Sun Mar 24 21:26:05 2019 +1100

    modified code for task5 and create a method getPositionFromString in Board.class

commit 37cc2ea19b0e74f09cd65d9ba09c87f4ede5a46a
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Sun Mar 24 20:38:19 2019 +1100

    1)Add comment in Board and replace "SquareString" with "tilePlacementString" for readability.  2) completed task5

commit e720ed12aad4514bdacf0f38a240944d2ca93012
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Fri Mar 22 22:32:16 2019 +1100

    finish task2

commit 74f07161a17d201e968c3e8e50e5b0f9fdd13ce1
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Fri Mar 22 22:31:34 2019 +1100

    finish task2

commit 373933d7e7d9c22002690b23cdeb638076aca97a
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Fri Mar 22 22:03:28 2019 +1100

    finish check A0-A5

commit 8d7566d1128ec5827b0781daacf2d350930525db
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Fri Mar 22 21:51:43 2019 +1100

    finish check A0-A5

commit 675130e314d4df2fc67c790dcf5c1ade74636603
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Fri Mar 22 21:42:53 2019 +1100

    Changed Boolean isStation of TypeSquare to isOverpass

commit e119af56111a505a4b10376e0ebfcf74f72f49e5
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Fri Mar 22 21:42:16 2019 +1100

    Changed Boolean isStation of TypeSquare to isOverpass

commit 209d500b59cb07f4dcc7bbb9b2c2221a07ae19aa
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Fri Mar 22 21:24:38 2019 +1100

    Added Tiles A0-A5 and checked B0-B2

commit 27ecd149e522b713c3858964ebf0b28930d1f7c7
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Fri Mar 22 20:59:37 2019 +1100

    add B0-B2 and checked S0-S5

commit d8435dc11d0fa53116c10eadf08ddbfca8f7dc4c
Merge: 999fc44 cea95d1
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Fri Mar 22 20:43:37 2019 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6474009/comp1110-ass2
    
    # Conflicts:
    #	src/comp1110/ass2/model/Square.java

commit 999fc44c7dc8509b9b1711bf2875d52cb37c916b
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Fri Mar 22 20:28:21 2019 +1100

    add B0-B2 and checked S0-S5

commit cea95d11651e574e55e6860fb70446dc21b5ec87
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Fri Mar 22 19:50:23 2019 +1100

    add TypeSquare

commit 3f80874083fdf404708b5cbd5e2f82ecf631b716
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Fri Mar 22 19:44:38 2019 +1100

    change model of square and tile

commit 28f0c54c5d5b08e5e36832c5043184b8d46c68ec
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Fri Mar 22 19:33:24 2019 +1100

    finish coding tileA

commit aee7d9071a0d876cf5f9035ced45e3c033ae6498
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Fri Mar 22 19:22:26 2019 +1100

    add check flag

commit 6b728dbbb86d526574d0498bb866dd2752990186
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Fri Mar 22 19:14:27 2019 +1100

    update TileA0-A5

commit 87f0a67a1ea2b01ea570f9cbe66f23eacfe13a1c
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Fri Mar 22 16:57:27 2019 +1100

    fix off-by-one errors in Javadoc spec

commit a068753972727f9fff85c6c43b12a1e19589a653
Author: Yue ZHANG <u6797258@anu.edu.au>
Date:   Fri Mar 22 14:20:26 2019 +1100

    model initialzie

commit 6899cf1bfb33883edba7d29b261aa2e63950d6be
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Thu Mar 21 21:40:31 2019 +1100

    fix specification for dice roll - B can only roll 0-2
    
    fix IsTilePlacementWellFormedTest and GenerateDiceRollTest accordingly

commit b46870d070bced2c61a522ed236dc4a58b722107
Author: rbdm <mirhadydorodjatun@gmail.com>
Date:   Thu Mar 21 15:52:15 2019 +1100

    Recorded member names, uid, phone number, weekly meeting time and roles.

commit 1c6213aca36a22ca9189f6a6e7698f79333390b7
Author: ChangZhehao <changzhehao@gmail.com>
Date:   Thu Mar 21 15:44:14 2019 +1100

    checkstyle update

commit 984e9fef1b9f26e2d4f38cf136ad5e85b4a9a6cd
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Mar 19 02:08:41 2019 +1100

    assignment published
```
## Changes
``` diff
diff -ru -x .git ../master/comp1110-ass2/admin/B-contribution.md comp1110-ass2/admin/B-contribution.md
--- ../master/comp1110-ass2/admin/B-contribution.md	2019-05-24 08:28:25.531581500 +1000
+++ comp1110-ass2/admin/B-contribution.md	2019-05-24 08:36:42.330713400 +1000
@@ -1,7 +1,7 @@
 We declare that the work toward our submission of Stage B was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0234567 30
+* u6613739 (35)
+* u6797258 (32)
+* u6474009 (33)
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0234567)
+Signed: Mirhady Dorodjatun (uid: u6474009), Yue Zhang (uid: u6797258), Zhehao_Chang (uid: u6613739)
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/admin/B-originality.md comp1110-ass2/admin/B-originality.md
--- ../master/comp1110-ass2/admin/B-originality.md	2019-05-24 08:28:25.536566700 +1000
+++ comp1110-ass2/admin/B-originality.md	2019-05-24 08:36:42.335700800 +1000
@@ -1,9 +1,3 @@
-We declare that the work we have submitted for Stage B of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
+We declare that the work we have submitted for Stage B of this assignment and all stages before it is entirely our own work.
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
-
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-*  ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Mirhady Dorodjatun (uid: u6474009), Yue Zhang (uid: u6797258), Zhehao_Chang (uid: u6613739)
diff -ru -x .git ../master/comp1110-ass2/admin/C-contribution.md comp1110-ass2/admin/C-contribution.md
--- ../master/comp1110-ass2/admin/C-contribution.md	2019-05-24 08:28:25.541566300 +1000
+++ comp1110-ass2/admin/C-contribution.md	2019-05-24 08:36:42.342710000 +1000
@@ -1,7 +1,7 @@
-We declare that the work toward our submission of Stage C was distributed among the group members as follows:
+We declare that the work toward our submission of Stage B was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0234567 30
+* u6613739 (33.3)
+* u6797258 (33.3)
+* u6474009 (33.3)
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0234567)
+Signed: Mirhady Dorodjatun (uid: u6474009), Yue Zhang (uid: u6797258), Zhehao_Chang (uid: u6613739)
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/admin/C-originality.md comp1110-ass2/admin/C-originality.md
--- ../master/comp1110-ass2/admin/C-originality.md	2019-05-24 08:28:25.546588700 +1000
+++ comp1110-ass2/admin/C-originality.md	2019-05-24 08:36:42.348698400 +1000
@@ -1,9 +1,3 @@
-We declare that the work we have submitted for Stage C of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
+We declare that the work we have submitted for Stage B of this assignment and all stages before it is entirely our own work.
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
-
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-*  ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Mirhady Dorodjatun (uid: u6474009), Yue Zhang (uid: u6797258), Zhehao_Chang (uid: u6613739)
Only in comp1110-ass2/admin: D-originality-u6474009.md
Only in comp1110-ass2/admin: D-originality-u6613739.md
Only in comp1110-ass2/admin: D-originality-u6797258.md
Only in comp1110-ass2/admin: E-originality-u6474009.md
Only in comp1110-ass2/admin: E-originality-u6613739.md
Only in comp1110-ass2/admin: E-originality-u6797258.md
diff -ru -x .git ../master/comp1110-ass2/admin/F-contribution.md comp1110-ass2/admin/F-contribution.md
--- ../master/comp1110-ass2/admin/F-contribution.md	2019-05-24 08:28:25.561563800 +1000
+++ comp1110-ass2/admin/F-contribution.md	2019-05-24 08:36:42.386703800 +1000
@@ -1,8 +1,7 @@
-We declare that the work toward our submission of Stage F was distributed among the group members as follows:
+We declare that the work toward our submission of Stage B was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0123456 30
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+* u6613739 (33.3)
+* u6797258 (33.3)
+* u6474009 (33.3)
 
+Signed: Mirhady Dorodjatun (uid: u6474009), Yue Zhang (uid: u6797258), Zhehao_Chang (uid: u6613739)
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/admin/F-originality.md comp1110-ass2/admin/F-originality.md
--- ../master/comp1110-ass2/admin/F-originality.md	2019-05-24 08:28:25.566566200 +1000
+++ comp1110-ass2/admin/F-originality.md	2019-05-24 08:36:42.388722400 +1000
@@ -1,9 +1,3 @@
-We declare that the work we have submitted for Stage F of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
+We declare that the work we have submitted for Stage F of this assignment and all stages before it is entirely our own work.
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
-
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-* ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Mirhady Dorodjatun (uid: u6474009), Yue Zhang (uid: u6797258), Zhehao_Chang (uid: u6613739)
Only in comp1110-ass2/admin: F-review-u6474009.md
Only in comp1110-ass2/admin: F-review-u6613739.md
Only in comp1110-ass2/admin: F-review-u6797258.md
Only in comp1110-ass2/admin: G-best-u6474009.md
Only in comp1110-ass2/admin: G-best-u6613739.md
Only in comp1110-ass2/admin: G-best-u6797258.md
diff -ru -x .git ../master/comp1110-ass2/admin/G-contribution.md comp1110-ass2/admin/G-contribution.md
--- ../master/comp1110-ass2/admin/G-contribution.md	2019-05-24 08:28:25.581566000 +1000
+++ comp1110-ass2/admin/G-contribution.md	2019-05-24 08:36:42.429717700 +1000
@@ -1,8 +1,7 @@
 We declare that the work toward our submission of Stage G was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0123456 30
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+* u6613739 (33.3)
+* u6797258 (33.3)
+* u6474009 (33.3)
 
+Signed: Mirhady Dorodjatun (uid: u6474009), Yue Zhang (uid: u6797258), Zhehao Chang (uid: u6613739)
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/admin/G-features.md comp1110-ass2/admin/G-features.md
--- ../master/comp1110-ass2/admin/G-features.md	2019-05-24 08:28:25.586572500 +1000
+++ comp1110-ass2/admin/G-features.md	2019-05-24 19:28:58.942223100 +1000
@@ -1,13 +1,23 @@
 In addition to the features that are auto-graded, the graphical user interface
 of our project implements the following features:
-
 *(Remove those that are unimplemented)*
 
- - A simple placement viewer (Task 4)
- - A basic playable game
- - A basic playable game that snaps pieces to the board and checks for validity (Task 7)
- - Generates basic starting piece placements (Task 8)
- - Implements hints (Task 10)
- - Implements interesting starting placements (Task 11)
-
-additional features...
+ - The game can be played by human and/or AI player.
+ - For AI type players, the user can set the difficulty (Easy or Hard).
+ - The game also supports multiple human players and/or AIs. It should support any natural number but we just set it between 1 to 4 player.
+ - Allow the player to choose tiles from a generated dice roll. On the same round, all players have the same dice roll.
+ - The tiles are separated into special and regular tile, all draggable and rotatable with right click
+ - The players can use special tiles at most once in one round and 3 times per game, 
+   and each special tiles can only be used once (follows the rules of the original board game)
+ - In each turn, the player need to place all 4 tiles that generated from the dice roll, unless there are no more valid placements that can be made.
+ - After dragged, if it is on the board the tiles would snap to the nearest square, otherwise snap to home position and shows relevant warning message at bottom.
+ - The game ends after 7 rounds
+ - Compute the total score (basic + bonus scoring) for every player after game ends
+ - Implement a smarter AI with DFS, Greedy algorithm and softmax. (Task 13)
+ - It implements a "Take Back" button that can take back all the tiles just placed by the current player in the current round.
+ - High Score menu, displays list of 5 human players with top scores (store the best 5 score into a txt).
+ - It implements a user-friendly warning label (below the board) that displays what is happening on the board such as invalid placement, 
+   special tiles turn & game limit reached, please click next turn because there are no more move available, etc. (Makes it easy for a new user to run).
+ 
+ 
+ 
diff -ru -x .git ../master/comp1110-ass2/admin/G-originality.md comp1110-ass2/admin/G-originality.md
--- ../master/comp1110-ass2/admin/G-originality.md	2019-05-24 08:28:25.591582300 +1000
+++ comp1110-ass2/admin/G-originality.md	2019-05-24 08:36:42.440702200 +1000
@@ -1,9 +1,3 @@
-We declare that the work we have submitted for Stage G of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
+We declare that the work we have submitted for Stage G of this assignment and all stages before it is entirely our own work.
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
-
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-* ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Mirhady Dorodjatun (uid: u6474009), Yue Zhang (uid: u6797258), Zhehao Chang (uid: u6613739)
Only in comp1110-ass2/admin: members-list
Only in comp1110-ass2: bestScore.txt
diff -ru -x .git ../master/comp1110-ass2/comp1110-ass2.iml comp1110-ass2/comp1110-ass2.iml
--- ../master/comp1110-ass2/comp1110-ass2.iml	2019-05-24 08:28:25.678618300 +1000
+++ comp1110-ass2/comp1110-ass2.iml	2019-05-24 08:36:42.533749600 +1000
@@ -1,6 +1,13 @@
 <?xml version="1.0" encoding="UTF-8"?>
 <module type="JAVA_MODULE" version="4">
-  <component name="NewModuleRootManager" inherit-compiler-output="true">
+  <component name="CheckStyle-IDEA-Module">
+    <option name="configuration">
+      <map>
+        <entry key="active-configuration" value="LOCAL_FILE:D:/MY/huaweicheckstyle.xml:huawei Checks" />
+      </map>
+    </option>
+  </component>
+  <component name="NewModuleRootManager" LANGUAGE_LEVEL="JDK_11" inherit-compiler-output="true">
     <exclude-output />
     <content url="file://$MODULE_DIR$">
       <sourceFolder url="file://$MODULE_DIR$/src" isTestSource="false" />
@@ -13,6 +20,16 @@
         <CLASSES>
           <root url="jar://$APPLICATION_HOME_DIR$/lib/junit-4.12.jar!/" />
           <root url="jar://$APPLICATION_HOME_DIR$/lib/hamcrest-core-1.3.jar!/" />
+        </CLASSES>
+        <JAVADOC />
+        <SOURCES />
+      </library>
+    </orderEntry>
+    <orderEntry type="module-library">
+      <library>
+        <CLASSES>
+          <root url="jar://$APPLICATION_HOME_DIR$/lib/junit-4.12.jar!/" />
+          <root url="jar://$APPLICATION_HOME_DIR$/lib/hamcrest-core-1.3.jar!/" />
         </CLASSES>
         <JAVADOC />
         <SOURCES />
Only in comp1110-ass2: feedback.md
Only in comp1110-ass2: game.jar
Only in comp1110-ass2/.idea: artifacts
Only in comp1110-ass2/.idea: checkstyle-idea.xml
diff -ru -x .git ../master/comp1110-ass2/.idea/libraries/javafx.xml comp1110-ass2/.idea/libraries/javafx.xml
--- ../master/comp1110-ass2/.idea/libraries/javafx.xml	2019-05-24 08:28:25.452567900 +1000
+++ comp1110-ass2/.idea/libraries/javafx.xml	2019-05-24 08:36:42.276713300 +1000
@@ -1,13 +1,24 @@
 <component name="libraryTable">
   <library name="javafx">
     <CLASSES>
-      <root url="file://$PATH_TO_FX$" />
+      <root url="jar://$PATH_TO_FX$/javafx-swt.jar!/" />
+      <root url="jar://$PATH_TO_FX$/javafx.base.jar!/" />
+      <root url="jar://$PATH_TO_FX$/javafx.controls.jar!/" />
+      <root url="jar://$PATH_TO_FX$/javafx.fxml.jar!/" />
+      <root url="jar://$PATH_TO_FX$/javafx.graphics.jar!/" />
+      <root url="jar://$PATH_TO_FX$/javafx.media.jar!/" />
+      <root url="jar://$PATH_TO_FX$/javafx.swing.jar!/" />
+      <root url="jar://$PATH_TO_FX$/javafx.web.jar!/" />
     </CLASSES>
     <JAVADOC />
     <SOURCES>
-      <root url="file://$PATH_TO_FX$" />
+      <root url="jar://$PATH_TO_FX$/src.zip!/javafx.base" />
+      <root url="jar://$PATH_TO_FX$/src.zip!/javafx.controls" />
+      <root url="jar://$PATH_TO_FX$/src.zip!/javafx.fxml" />
+      <root url="jar://$PATH_TO_FX$/src.zip!/javafx.graphics" />
+      <root url="jar://$PATH_TO_FX$/src.zip!/javafx.media" />
+      <root url="jar://$PATH_TO_FX$/src.zip!/javafx.swing" />
+      <root url="jar://$PATH_TO_FX$/src.zip!/javafx.web" />
     </SOURCES>
-    <jarDirectory url="file://$PATH_TO_FX$" recursive="false" />
-    <jarDirectory url="file://$PATH_TO_FX$" recursive="false" type="SOURCES" />
   </library>
 </component>
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Viewer.xml comp1110-ass2/.idea/runConfigurations/Viewer.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Viewer.xml	2019-05-24 08:28:25.519584100 +1000
+++ comp1110-ass2/.idea/runConfigurations/Viewer.xml	2019-05-24 08:36:42.316736700 +1000
@@ -2,7 +2,7 @@
   <configuration default="false" name="Viewer" type="Application" factoryName="Application" nameIsGenerated="true">
     <option name="MAIN_CLASS_NAME" value="comp1110.ass2.gui.Viewer" />
     <module name="comp1110-ass2" />
-    <option name="VM_PARAMETERS" value="-ea --module-path ${PATH_TO_FX} --add-modules=javafx.controls,javafx.fxml,javafx.media" />
+    <option name="VM_PARAMETERS" value="-ea  --module-path ${PATH_TO_FX} --add-modules=javafx.controls,javafx.fxml,javafx.media" />
     <extension name="coverage">
       <pattern>
         <option name="PATTERN" value="comp1110.ass2.gui.*" />
@@ -13,4 +13,4 @@
       <option name="Make" enabled="true" />
     </method>
   </configuration>
-</component>
+</component>
\ No newline at end of file
Only in comp1110-ass2: presentation.pdf
Only in comp1110-ass2/src/comp1110/ass2: controller
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: A0.jpg
Only in ../master/comp1110-ass2/src/comp1110/ass2/gui/assets: A0.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: A1.jpg
Only in ../master/comp1110-ass2/src/comp1110/ass2/gui/assets: A1.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: A2.jpg
Only in ../master/comp1110-ass2/src/comp1110/ass2/gui/assets: A2.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: A3.jpg
Only in ../master/comp1110-ass2/src/comp1110/ass2/gui/assets: A3.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: A4.jpg
Only in ../master/comp1110-ass2/src/comp1110/ass2/gui/assets: A4.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: A5.jpg
Only in ../master/comp1110-ass2/src/comp1110/ass2/gui/assets: A5.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: B0.jpg
Only in ../master/comp1110-ass2/src/comp1110/ass2/gui/assets: B0.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: B1.jpg
Only in ../master/comp1110-ass2/src/comp1110/ass2/gui/assets: B1.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: B2.jpg
Only in ../master/comp1110-ass2/src/comp1110/ass2/gui/assets: B2.png
Binary files ../master/comp1110-ass2/src/comp1110/ass2/gui/assets/Board.jpg and comp1110-ass2/src/comp1110/ass2/gui/assets/Board.jpg differ
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: EMPTY.jpg
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: HighExit.jpg
Only in ../master/comp1110-ass2/src/comp1110/ass2/gui/assets: HighExit.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: RailExit.jpg
Only in ../master/comp1110-ass2/src/comp1110/ass2/gui/assets: RailExit.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: S0.jpg
Only in ../master/comp1110-ass2/src/comp1110/ass2/gui/assets: S0.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: S1.jpg
Only in ../master/comp1110-ass2/src/comp1110/ass2/gui/assets: S1.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: S2.jpg
Only in ../master/comp1110-ass2/src/comp1110/ass2/gui/assets: S2.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: S3.jpg
Only in ../master/comp1110-ass2/src/comp1110/ass2/gui/assets: S3.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: S4.jpg
Only in ../master/comp1110-ass2/src/comp1110/ass2/gui/assets: S4.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: S5.jpg
Only in ../master/comp1110-ass2/src/comp1110/ass2/gui/assets: S5.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: WALL.jpg
Only in comp1110-ass2/src/comp1110/ass2/gui: Viewer.class
diff -ru -x .git ../master/comp1110-ass2/src/comp1110/ass2/gui/Viewer.java comp1110-ass2/src/comp1110/ass2/gui/Viewer.java
--- ../master/comp1110-ass2/src/comp1110/ass2/gui/Viewer.java	2019-05-24 08:28:25.695563600 +1000
+++ comp1110-ass2/src/comp1110/ass2/gui/Viewer.java	2019-05-24 08:36:42.755700200 +1000
@@ -1,11 +1,14 @@
 package comp1110.ass2.gui;
 
+import comp1110.ass2.model.Board;
+import comp1110.ass2.util.GuiUtil;
 import javafx.application.Application;
 import javafx.scene.Group;
 import javafx.scene.Scene;
 import javafx.scene.control.Button;
 import javafx.scene.control.Label;
 import javafx.scene.control.TextField;
+import javafx.scene.layout.BorderPane;
 import javafx.scene.layout.HBox;
 import javafx.stage.Stage;
 
@@ -31,10 +34,18 @@
      *
      * @param placement A valid placement string
      */
-    void makePlacement(String placement) {
+    void makePlacement(String placement)
+    {
         // FIXME Task 4: implement the simple placement viewer
+        BorderPane borderPane = new BorderPane();
+        Board border = new Board();
+        BorderPane mapPanel = GuiUtil.updateGuiByPlacementString(borderPane,border,placement,this.getClass().getResource("")+URI_BASE);
+        GuiUtil.cleanCanvas(root);
+        root.getChildren().add(mapPanel);
+
     }
 
+
     /**
      * Create a basic text field for input and a refresh button.
      */
Only in comp1110-ass2/src/comp1110/ass2: model
Only in comp1110-ass2/src/comp1110/ass2: OurTest.class
Only in comp1110-ass2/src/comp1110/ass2: OurTest.java
Only in comp1110-ass2/src/comp1110/ass2: RailroadInk.class
diff -ru -x .git ../master/comp1110-ass2/src/comp1110/ass2/RailroadInk.java comp1110-ass2/src/comp1110/ass2/RailroadInk.java
--- ../master/comp1110-ass2/src/comp1110/ass2/RailroadInk.java	2019-05-24 08:28:25.686567900 +1000
+++ comp1110-ass2/src/comp1110/ass2/RailroadInk.java	2019-05-24 08:36:42.719716500 +1000
@@ -1,5 +1,10 @@
 package comp1110.ass2;
 
+import comp1110.ass2.model.Board;
+import comp1110.ass2.model.Square;
+
+import java.util.Random;
+
 public class RailroadInk {
     /**
      * Determine whether a tile placement string is well-formed:
@@ -15,7 +20,16 @@
      */
     public static boolean isTilePlacementWellFormed(String tilePlacementString) {
         // FIXME Task 2: determine whether a tile placement is well-formed
-        return false;
+        Board board = new Board();
+        Square square = board.getSquareFromSquareString(tilePlacementString);
+        if (square != null)
+        {
+            return true;
+        }
+        else
+        {
+            return false;
+        }
     }
 
     /**
@@ -29,7 +43,19 @@
      */
     public static boolean isBoardStringWellFormed(String boardString) {
         // FIXME Task 3: determine whether a board string is well-formed
-        return false;
+        if (boardString == null || boardString.length() == 0 || boardString.length() % 5 != 0 || boardString.length() > (5*31)) return false;
+        int specialTileLimit = 3;
+        for (int i = 0; i < boardString.length(); i += 5)
+        {
+            String tilePlacementString = boardString.substring(i, i + 5);
+            if ( ! isTilePlacementWellFormed(tilePlacementString)) return false;
+            else if (tilePlacementString.charAt(0) == 'S')
+            {
+                specialTileLimit -= 1;
+                if (specialTileLimit <= 0) return false;
+            }
+        }
+        return true;
     }
 
 
@@ -46,7 +72,9 @@
      */
     public static boolean areConnectedNeighbours(String tilePlacementStringA, String tilePlacementStringB) {
         // FIXME Task 5: determine whether neighbouring placements are connected
-        return false;
+        Board b = new Board();
+        boolean r = b.areConnectedSquares(tilePlacementStringA,tilePlacementStringB);
+        return  r;
     }
 
     /**
@@ -67,7 +95,9 @@
      */
     public static boolean isValidPlacementSequence(String boardString) {
         // FIXME Task 6: determine whether the given placement sequence is valid
-        return false;
+        if ( ! isBoardStringWellFormed(boardString)) return false;
+        Board board = new Board();
+        return board.isValidBoardStringPlacement(boardString);
     }
 
     /**
@@ -82,7 +112,14 @@
      */
     public static String generateDiceRoll() {
         // FIXME Task 7: generate a dice roll
-        return "";
+        Random random = new Random();
+        int a1 = random.nextInt(6);
+        int a2 = random.nextInt(6);
+        int a3 = random.nextInt(6);
+        int rollFour = random.nextInt(3);
+        String roll = "A"+Integer.toString(a1)+"A"+Integer.toString(a2)+
+                "A"+Integer.toString(a3)+"B"+Integer.toString(rollFour);
+        return roll;
     }
 
     /**
@@ -98,7 +135,10 @@
      */
     public static int getBasicScore(String boardString) {
         // FIXME Task 8: compute the basic score
-        return -1;
+        Board board = new Board();
+        board.putPlacementStringToMap(boardString);
+        int x = board.getBasicScoring();
+        return x;
     }
 
     /**
@@ -111,7 +151,9 @@
      */
     public static String generateMove(String boardString, String diceRoll) {
         // FIXME Task 10: generate a valid move
-        return null;
+        Board board = new Board();
+        board.putPlacementStringToMap(boardString);
+        return board.getPossibleDicePlacementSequence(diceRoll);
     }
 
     /**
@@ -126,7 +168,9 @@
      */
     public static int getAdvancedScore(String boardString) {
         // FIXME Task 12: compute the total score including bonus points
-        return -1;
+        Board board = new Board();
+        board.putPlacementStringToMap(boardString);
+        return board.getBonusScoring();
     }
 }
 
Only in comp1110-ass2/src/comp1110/ass2: util
Only in comp1110-ass2/src: guidemo
Only in comp1110-ass2/src: META-INF
Only in comp1110-ass2/src: resource
Only in comp1110-ass2/tests: u6474009
Only in comp1110-ass2/tests: u6613739
Only in comp1110-ass2/tests: u6797258
```
## Test log
```
--javac output--
----
JUnit version 4.12
...
Time: 0.353

OK (3 tests)

JUnit version 4.12
......
Time: 0.319

OK (6 tests)

JUnit version 4.12
.....
Time: 0.188

OK (5 tests)

JUnit version 4.12
...E..
Time: 0.681
There was 1 failure:
1) testGood(comp1110.ass2.IsValidPlacementSequenceTest)
java.lang.AssertionError: Placement sequence 'A3A10B2A31A1B30A0F61A4A21B1B14A4A41A4D61S2A50A5A63A2B01A1C02B0G52S0B63A0E63A2E51A4D51B0C32A5D31A5C61A0E41S5D41' is valid, but failed 
	at org.junit.Assert.fail(Assert.java:88)
	at org.junit.Assert.assertTrue(Assert.java:41)
	at comp1110.ass2.IsValidPlacementSequenceTest.testGood(IsValidPlacementSequenceTest.java:25)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.internal.runners.statements.FailOnTimeout$CallableStatement.call(FailOnTimeout.java:298)
	at org.junit.internal.runners.statements.FailOnTimeout$CallableStatement.call(FailOnTimeout.java:292)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at java.base/java.lang.Thread.run(Thread.java:834)

FAILURES!!!
Tests run: 5,  Failures: 1

JUnit version 4.12
....
Time: 0.546

OK (4 tests)

JUnit version 4.12
.Sample game A3D61A3D53B0C52A0B52A2B63A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33A1A30S4E11A4E21A3C21A3C31S5F11
score 24
Sample game A3A10A3A52A3G10B2F10S1B50A2B61A0C60A1B41B1A35A4A41A2B31A1C30B0D32A2C50A4E10A3D12B2B10A2F01A0G00A4D01B1A27S3B20A4C10A1D50A0F23B2G25A3E30A4E41
score 18
Sample game A2A30A0A43A3A50B2B50A4C50A3D50A2B43B0G12B0A14A2B33A0B11A4E50A3D61A2B21A3G52B1G45A3F52B2F41A3F33A1E40A1D40A3E32A3E27B0F10S0E12B1D17A4D01A1B61A0C43
score 21
Sample game A4A50A1F61A0B61S5F50B1F46A1F01S1F12A2F23A1E20B2D21A3D03A1C20A0B22B1A61A4D11A4G10B1G44A2G30A3C01A3C12B0B31A1B01A4B50B0C50A2F32A0E32A0E40A4D31B1D47A1B11
score 15
Sample game A4A50A1A30B2B31A0C34A3B41B2C40A3B52A2B60A2C62S5C50B1D65A4B21A2A60A3B10A4A10A4C10B2G10B2F10A4E10A3D12A1F01S2D00A4C00B1B02A0F23A0G20A2F61B2F50A3G52A0G02
score 23
Sample game A4G10B2F10A4E10A0F20A3D17A0E22A2E31B1E44S0D42A3D23A4D31A2F30B1F42A1G30A0C42A0C57B0C22A2F03A1E02S5D01A0B22B0A50A4D51A3D61B2B53A0B30B2A31A4E60A3A41A0B03
score 23
Sample game A3A10B2A31A1B30A0F61A4A21B1B14A4A41A4D61S2A50A5A63A2B01A1C02B0G52S0B63A0E63A2E51A4D51B0C32A5D31A5C61A0E41S5D41B1D03A5B51A4G10A0C42B0G30A2F52A5F12B2F21A0F00
score 26
Sample game A0B06A5A50A5A42A3B44A3C42A3D44B2D35B2C37A0B33A2B27A2E35B2C27A4C13A5C05A1F01B2D21A1F15A5D04A4D11A2E20B1B10A4A10S4E44A3E55A2F25S3F40B2F30A3D50A4D67
score 13
Sample game B2A37A3A43A3A54A3A21A5A14B2B20A0B30A4C20A1B17A2B07B2D05A0E04A1C00B0G16A0F13A0G32B2D11A5D20A0E10A5B51B2G46A4F40A5E42A0C15B1G52A5E50A1F03A2F63
score 18
Sample game A1A30A3D05A3C06B0B06A3C13A3C27B2C33A1B30B0D32A5E30A0A02A2A11S4E24S2D20A4D15B0B16A1E17A0E02A3C43A4B40A3A47A5A50A3C57B0D50A0E51A0E63A0F64
score 13
...
Time: 0.519

OK (4 tests)

JUnit version 4.12
.....
Time: 1.19

OK (5 tests)

JUnit version 4.12
.Sample game A3D61A3D53B0C52A0B52A2B63A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33A1A30S4E11A4E21A3C21A3C31S5F11
score 41
Sample game A3A10A3A52A3G10B2F10S1B50A2B61A0C60A1B41B1A35A4A41A2B31A1C30B0D32A2C50A4E10A3D12B2B10A2F01A0G00A4D01B1A27S3B20A4C10A1D50A0F23B2G25A3E30A4E41
score 36
Sample game A2A30A0A43A3A50B2B50A4C50A3D50A2B43B0G12B0A14A2B33A0B11A4E50A3D61A2B21A3G52B1G45A3F52B2F41A3F33A1E40A1D40A3E32A3E27B0F10S0E12B1D17A4D01A1B61A0C43
score 42
Sample game A4A50A1F61A0B61S5F50B1F46A1F01S1F12A2F23A1E20B2D21A3D03A1C20A0B22B1A61A4D11A4G10B1G44A2G30A3C01A3C12B0B31A1B01A4B50B0C50A2F32A0E32A0E40A4D31B1D47A1B11
score 32
Sample game A4A50A1A30B2B31A0C34A3B41B2C40A3B52A2B60A2C62S5C50B1D65A4B21A2A60A3B10A4A10A4C10B2G10B2F10A4E10A3D12A1F01S2D00A4C00B1B02A0F23A0G20A2F61B2F50A3G52A0G02
score 42
Sample game A4G10B2F10A4E10A0F20A3D17A0E22A2E31B1E44S0D42A3D23A4D31A2F30B1F42A1G30A0C42A0C57B0C22A2F03A1E02S5D01A0B22B0A50A4D51A3D61B2B53A0B30B2A31A4E60A3A41A0B03
score 42
Sample game A3A10B2A31A1B30A0F61A4A21B1B14A4A41A4D61S2A50A5A63A2B01A1C02B0G52S0B63A0E63A2E51A4D51B0C32A5D31A5C61A0E41S5D41B1D03A5B51A4G10A0C42B0G30A2F52A5F12B2F21A0F00
score 41
Sample game A0B06A5A50A5A42A3B44A3C42A3D44B2D35B2C37A0B33A2B27A2E35B2C27A4C13A5C05A1F01B2D21A1F15A5D04A4D11A2E20B1B10A4A10S4E44A3E55A2F25S3F40B2F30A3D50A4D67
score 44
Sample game B2A37A3A43A3A54A3A21A5A14B2B20A0B30A4C20A1B17A2B07B2D05A0E04A1C00B0G16A0F13A0G32B2D11A5D20A0E10A5B51B2G46A4F40A5E42A0C15B1G52A5E50A1F03A2F63
score 39
Sample game A1A30A3D05A3C06B0B06A3C13A3C27B2C33A1B30B0D32A5E30A0A02A2A11S4E24S2D20A4D15B0B16A1E17A0E02A3C43A4B40A3A47A5A50A3C57B0D50A0E51A0E63A0F64
score 31
.
Time: 0.236

OK (2 tests)

```
