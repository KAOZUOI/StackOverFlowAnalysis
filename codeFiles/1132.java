java.lang.AssertionError    at com.ibm.xml.xlxp2.runtime.VMContext.stopSchemaAssessment(VMContext.java:609)    at com.ibm.xml.xlxp2.api.jaxb.JAXBXMLStreamReader.unmarshal(JAXBXMLStreamReader.java:127)    at com.ibm.xml.xlxp2.jaxb.unmarshal.UnmarshallerImpl.unmarshal(UnmarshallerImpl.java:256)    at com.sun.xml.internal.ws.assembler.MetroConfigLoader.loadMetroConfig(MetroConfigLoader.java:256)    at com.sun.xml.internal.ws.assembler.MetroConfigLoader.init(MetroConfigLoader.java:143)    at com.sun.xml.internal.ws.assembler.MetroConfigLoader.<init>(MetroConfigLoader.java:116)    at com.sun.xml.internal.ws.assembler.TubelineAssemblyController.getTubeCreators(TubelineAssemblyController.java:90)    at com.sun.xml.internal.ws.assembler.MetroTubelineAssembler.createClient(MetroTubelineAssembler.java:115)    at com.sun.xml.internal.ws.client.Stub.createPipeline(Stub.java:340)    at com.sun.xml.internal.ws.client.Stub.<init>(Stub.java:307)    at com.sun.xml.internal.ws.client.Stub.<init>(Stub.java:240)    at com.sun.xml.internal.ws.client.Stub.<init>(Stub.java:255)    at com.sun.xml.internal.ws.client.sei.SEIStub.<init>(SEIStub.java:96)    at com.sun.xml.internal.ws.client.WSServiceDelegate.getStubHandler(WSServiceDelegate.java:827)    at com.sun.xml.internal.ws.client.WSServiceDelegate.createEndpointIFBaseProxy(WSServiceDelegate.java:816)    at com.sun.xml.internal.ws.client.WSServiceDelegate.getPort(WSServiceDelegate.java:449)    at com.sun.xml.internal.ws.client.WSServiceDelegate.getPort(WSServiceDelegate.java:417)    at com.sun.xml.internal.ws.client.WSServiceDelegate.getPort(WSServiceDelegate.java:399)    at javax.xml.ws.Service.getPort(Service.java:130)