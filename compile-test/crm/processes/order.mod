[Ivy]
1700F6B9A99952AD 9.2.0 #module
>Proto >Proto Collection #zClass
or0 order Big #zClass
or0 B #cInfo
or0 #process
or0 @TextInP .type .type #zField
or0 @TextInP .processKind .processKind #zField
or0 @TextInP .xml .xml #zField
or0 @TextInP .responsibility .responsibility #zField
or0 @StartRequest f0 '' #zField
or0 @EndTask f1 '' #zField
or0 @UserDialog f3 '' #zField
or0 @PushWFArc f4 '' #zField
or0 @PushWFArc f2 '' #zField
>Proto or0 or0 order #zField
or0 f0 outLink orderProduct.ivp #txt
or0 f0 inParamDecl '<> param;' #txt
or0 f0 requestEnabled true #txt
or0 f0 triggerEnabled false #txt
or0 f0 callSignature orderProduct() #txt
or0 f0 caseData businessCase.attach=true #txt
or0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>orderProduct.ivp</name>
    </language>
</elementInfo>
' #txt
or0 f0 @C|.responsibility Everybody #txt
or0 f0 81 49 30 30 -54 26 #rect
or0 f1 337 49 30 30 0 15 #rect
or0 f3 dialogId crm.OrderForm #txt
or0 f3 startMethod start() #txt
or0 f3 requestActionDecl '<> param;' #txt
or0 f3 responseMappingAction 'out=in;
out.order=result.order;
' #txt
or0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>order products</name>
    </language>
</elementInfo>
' #txt
or0 f3 168 42 112 44 -47 -7 #rect
or0 f4 111 64 168 64 #arcP
or0 f2 280 64 337 64 #arcP
>Proto or0 .type crm.Data #txt
>Proto or0 .processKind NORMAL #txt
>Proto or0 0 0 32 24 18 0 #rect
>Proto or0 @|BIcon #fIcon
or0 f0 mainOut f4 tail #connect
or0 f4 head f3 mainIn #connect
or0 f3 mainOut f2 tail #connect
or0 f2 head f1 mainIn #connect
