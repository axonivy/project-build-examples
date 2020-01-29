[Ivy]
16FF0CE63FC4D90F 7.5.0 #module
>Proto >Proto Collection #zClass
Ss0 SimpleInputFormProcess Big #zClass
Ss0 RD #cInfo
Ss0 #process
Ss0 @TextInP .type .type #zField
Ss0 @TextInP .processKind .processKind #zField
Ss0 @TextInP .xml .xml #zField
Ss0 @TextInP .responsibility .responsibility #zField
Ss0 @UdInit f0 '' #zField
Ss0 @UdProcessEnd f1 '' #zField
Ss0 @PushWFArc f2 '' #zField
Ss0 @UdEvent f3 '' #zField
Ss0 @UdExitEnd f4 '' #zField
Ss0 @PushWFArc f5 '' #zField
>Proto Ss0 Ss0 SimpleInputFormProcess #zField
Ss0 f0 guid 16FF0CE6403F3F4A #txt
Ss0 f0 method start() #txt
Ss0 f0 inParameterDecl '<> param;' #txt
Ss0 f0 outParameterDecl '<String input> result;' #txt
Ss0 f0 outParameterMapAction 'result.input=in.input;
' #txt
Ss0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start()</name>
    </language>
</elementInfo>
' #txt
Ss0 f0 83 51 26 26 -20 15 #rect
Ss0 f0 @|UdInitIcon #fIcon
Ss0 f1 211 51 26 26 0 12 #rect
Ss0 f1 @|UdProcessEndIcon #fIcon
Ss0 f2 109 64 211 64 #arcP
Ss0 f3 guid 16FF0CE640A96270 #txt
Ss0 f3 actionTable 'out=in;
' #txt
Ss0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>close</name>
    </language>
</elementInfo>
' #txt
Ss0 f3 83 147 26 26 -16 15 #rect
Ss0 f3 @|UdEventIcon #fIcon
Ss0 f4 211 147 26 26 0 12 #rect
Ss0 f4 @|UdExitEndIcon #fIcon
Ss0 f5 109 160 211 160 #arcP
>Proto Ss0 .type ch.ivyteam.ivy.project.demo.ci.order.SimpleInputForm.SimpleInputFormData #txt
>Proto Ss0 .processKind HTML_DIALOG #txt
>Proto Ss0 -8 -8 16 16 16 26 #rect
>Proto Ss0 '' #fIcon
Ss0 f0 mainOut f2 tail #connect
Ss0 f2 head f1 mainIn #connect
Ss0 f3 mainOut f5 tail #connect
Ss0 f5 head f4 mainIn #connect
