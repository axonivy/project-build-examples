[Ivy]
1700F6E185CAFF13 9.2.0 #module
>Proto >Proto Collection #zClass
Os0 OrderFormProcess Big #zClass
Os0 RD #cInfo
Os0 #process
Os0 @TextInP .type .type #zField
Os0 @TextInP .processKind .processKind #zField
Os0 @TextInP .xml .xml #zField
Os0 @TextInP .responsibility .responsibility #zField
Os0 @UdInit f0 '' #zField
Os0 @UdProcessEnd f1 '' #zField
Os0 @UdEvent f3 '' #zField
Os0 @UdExitEnd f4 '' #zField
Os0 @PushWFArc f5 '' #zField
Os0 @UdEvent f9 '' #zField
Os0 @UdProcessEnd f10 '' #zField
Os0 @PushWFArc f2 '' #zField
Os0 @PushWFArc f6 '' #zField
Os0 @UdEvent f7 '' #zField
Os0 @UdProcessEnd f8 '' #zField
Os0 @PushWFArc f11 '' #zField
>Proto Os0 Os0 OrderFormProcess #zField
Os0 f0 guid 16FEC9D104D9804B #txt
Os0 f0 method start() #txt
Os0 f0 inParameterDecl '<> param;' #txt
Os0 f0 inParameterMapAction 'out.availableProducts=ch.ivyteam.crm.OrderUtil.getProducts();
' #txt
Os0 f0 inActionCode 'import crm.Product;
out.product = new Product();
Product first = out.availableProducts.get(0);
out.product.setName(first.getName());
out.product.setSinglePrice(first.getSinglePrice());
out.product.setAmount(1);' #txt
Os0 f0 outParameterDecl '<java.util.List<crm.Product> order> result;' #txt
Os0 f0 outParameterMapAction 'result.order=in.order;
' #txt
Os0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start()</name>
    </language>
</elementInfo>
' #txt
Os0 f0 83 51 26 26 -20 15 #rect
Os0 f1 211 51 26 26 0 12 #rect
Os0 f3 guid 16FEC9D105335426 #txt
Os0 f3 actionTable 'out=in;
' #txt
Os0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>close</name>
    </language>
</elementInfo>
' #txt
Os0 f3 83 211 26 26 -16 15 #rect
Os0 f4 211 211 26 26 0 12 #rect
Os0 f5 109 224 211 224 #arcP
Os0 f9 guid 16FECAA7D10597FE #txt
Os0 f9 actionTable 'out=in;
' #txt
Os0 f9 actionCode 'out.product.amount = 1;' #txt
Os0 f9 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>updatePrice</name>
    </language>
</elementInfo>
' #txt
Os0 f9 83 147 26 26 -38 15 #rect
Os0 f10 211 147 26 26 0 12 #rect
Os0 f2 109 64 211 64 #arcP
Os0 f6 109 160 211 160 #arcP
Os0 f7 guid 16FECC74C15EFD0E #txt
Os0 f7 actionTable 'out=in;
' #txt
Os0 f7 actionCode out.order.add(out.product); #txt
Os0 f7 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>addProduct</name>
    </language>
</elementInfo>
' #txt
Os0 f7 83 275 26 26 -36 15 #rect
Os0 f8 211 275 26 26 0 12 #rect
Os0 f11 109 288 211 288 #arcP
>Proto Os0 .type crm.OrderForm.OrderFormData #txt
>Proto Os0 .processKind HTML_DIALOG #txt
>Proto Os0 -8 -8 16 16 16 26 #rect
Os0 f3 mainOut f5 tail #connect
Os0 f5 head f4 mainIn #connect
Os0 f0 mainOut f2 tail #connect
Os0 f2 head f1 mainIn #connect
Os0 f9 mainOut f6 tail #connect
Os0 f6 head f10 mainIn #connect
Os0 f7 mainOut f11 tail #connect
Os0 f11 head f8 mainIn #connect
