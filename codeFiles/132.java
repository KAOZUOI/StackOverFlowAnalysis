  ======= EXCEPTION START ========    Exception class=[java.lang.RuntimeException]    com.gargoylesoftware.htmlunit.ScriptException: Exception invoking drawImage        at com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine$HtmlUnitContextAction.run(JavaScriptEngine.java:1001)        at net.sourceforge.htmlunit.corejs.javascript.Context.call(Context.java:590)        at net.sourceforge.htmlunit.corejs.javascript.ContextFactory.call(ContextFactory.java:484)        at com.gargoylesoftware.htmlunit.javascript.HtmlUnitContextFactory.callSecured(HtmlUnitContextFactory.java:349)        at com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine.callFunction(JavaScriptEngine.java:928)        at com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine.callFunction(JavaScriptEngine.java:900)        at com.gargoylesoftware.htmlunit.html.HtmlPage.executeJavaScriptFunction(HtmlPage.java:2620)        at com.gargoylesoftware.htmlunit.html.HtmlPage.executeJavaScriptFunction(HtmlPage.java:2613)        at com.gargoylesoftware.htmlunit.javascript.host.event.EventListenersContainer.executeEventListeners(EventListenersContainer.java:342)        at com.gargoylesoftware.htmlunit.javascript.host.event.EventListenersContainer.executeAtTargetListeners(EventListenersContainer.java:379)        at com.gargoylesoftware.htmlunit.javascript.host.event.EventTarget.fireEvent(EventTarget.java:173)        at com.gargoylesoftware.htmlunit.html.DomElement.lambda$fireEvent$0(DomElement.java:1496)        at com.gargoylesoftware.htmlunit.html.DomElement$$ExternalSyntheticLambda0.run(Unknown Source:4)        at net.sourceforge.htmlunit.corejs.javascript.Context.call(Context.java:590)        at net.sourceforge.htmlunit.corejs.javascript.ContextFactory.call(ContextFactory.java:484)        at com.gargoylesoftware.htmlunit.javascript.HtmlUnitContextFactory.callSecured(HtmlUnitContextFactory.java:349)        at com.gargoylesoftware.htmlunit.html.DomElement.fireEvent(DomElement.java:1496)        at com.gargoylesoftware.htmlunit.html.HtmlImage.fireEvent(HtmlImage.java:949)        at com.gargoylesoftware.htmlunit.html.HtmlImage.doOnLoad(HtmlImage.java:319)        at com.gargoylesoftware.htmlunit.html.HtmlImage$1.execute(HtmlImage.java:165)        at com.gargoylesoftware.htmlunit.html.HtmlPage.initialize(HtmlPage.java:342)        at com.gargoylesoftware.htmlunit.WebClient.loadWebResponseInto(WebClient.java:710)        at com.gargoylesoftware.htmlunit.WebClient.loadWebResponseInto(WebClient.java:592)        at com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:510)        at com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:417)        at com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:555)        at com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:537)        at com.test.xxx.thread.PTCThread.run(PTCThread.java:58)     Caused by: java.lang.RuntimeException: Exception invoking drawImage        at net.sourceforge.htmlunit.corejs.javascript.MemberBox.invoke(MemberBox.java:238)        at net.sourceforge.htmlunit.corejs.javascript.FunctionObject.call(FunctionObject.java:405)        at net.sourceforge.htmlunit.corejs.javascript.Interpreter.interpretLoop(Interpreter.java:1876)        at net.sourceforge.htmlunit.corejs.javascript.Interpreter.interpret(Interpreter.java:1053)        at net.sourceforge.htmlunit.corejs.javascript.InterpretedFunction.call(InterpretedFunction.java:89)        at net.sourceforge.htmlunit.corejs.javascript.ContextFactory.doTopCall(ContextFactory.java:392)        at com.gargoylesoftware.htmlunit.javascript.HtmlUnitContextFactory.doTopCall(HtmlUnitContextFactory.java:335)        at net.sourceforge.htmlunit.corejs.javascript.ScriptRuntime.doTopCall(ScriptRuntime.java:3916)        at com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine$3.doRun(JavaScriptEngine.java:921)        at com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine$HtmlUnitContextAction.run(JavaScriptEngine.java:984)        at net.sourceforge.htmlunit.corejs.javascript.Context.call(Context.java:590)         at net.sourceforge.htmlunit.corejs.javascript.ContextFactory.call(ContextFactory.java:484)         at com.gargoylesoftware.htmlunit.javascript.HtmlUnitContextFactory.callSecured(HtmlUnitContextFactory.java:349)         at com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine.callFunction(JavaScriptEngine.java:928)         at com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine.callFunction(JavaScriptEngine.java:900)         at com.gargoylesoftware.htmlunit.html.HtmlPage.executeJavaScriptFunction(HtmlPage.java:2620)         at com.gargoylesoftware.htmlunit.html.HtmlPage.executeJavaScriptFunction(HtmlPage.java:2613)         at com.gargoylesoftware.htmlunit.javascript.host.event.EventListenersContainer.executeEventListeners(EventListenersContainer.java:342)         at com.gargoylesoftware.htmlunit.javascript.host.event.EventListenersContainer.executeAtTargetListeners(EventListenersContainer.java:379)         at com.gargoylesoftware.htmlunit.javascript.host.event.EventTarget.fireEvent(EventTarget.java:173)         at com.gargoylesoftware.htmlunit.html.DomElement.lambda$fireEvent$0(DomElement.java:1496)         at com.gargoylesoftware.htmlunit.html.DomElement$$ExternalSyntheticLambda0.run(Unknown Source:4)         at net.sourceforge.htmlunit.corejs.javascript.Context.call(Context.java:590)         at net.sourceforge.htmlunit.corejs.javascript.ContextFactory.call(ContextFactory.java:484)         at com.gargoylesoftware.htmlunit.javascript.HtmlUnitContextFactory.callSecured(HtmlUnitContextFactory.java:349)         at com.gargoylesoftware.htmlunit.html.DomElement.fireEvent(DomElement.java:1496)         at com.gargoylesoftware.htmlunit.html.HtmlImage.fireEvent(HtmlImage.java:949)         at com.gargoylesoftware.htmlunit.html.HtmlImage.doOnLoad(HtmlImage.java:319)         at com.gargoylesoftware.htmlunit.html.HtmlImage$1.execute(HtmlImage.java:165)         at com.gargoylesoftware.htmlunit.html.HtmlPage.initialize(HtmlPage.java:342)         at com.gargoylesoftware.htmlunit.WebClient.loadWebResponseInto(WebClient.java:710)         at com.gargoylesoftware.htmlunit.WebClient.loadWebResponseInto(WebClient.java:592)         at com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:510)         at com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:417)         at com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:555)         at com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:537)         at com.test.xxx.thread.PTCThread.run(PTCThread.java:58)      Caused by: java.lang.NoClassDefFoundError: Failed resolution of: Ljavax/imageio/ImageIO;        at com.gargoylesoftware.htmlunit.html.HtmlImage.readImageIfNeeded(HtmlImage.java:702)2022-12-05 08:28:08.823 14255-14815/com.test.xxx E/JavaScriptErrorListener:     at com.gargoylesoftware.htmlunit.html.HtmlImage.getImageReader(HtmlImage.java:619)        at com.gargoylesoftware.htmlunit.javascript.host.canvas.CanvasRenderingContext2D.drawImage(CanvasRenderingContext2D.java:410)        at java.lang.reflect.Method.invoke(Native Method)        at net.sourceforge.htmlunit.corejs.javascript.MemberBox.invoke(MemberBox.java:215)            ... 36 more     Caused by: java.lang.ClassNotFoundException: Didn't find class &quot;javax.imageio.ImageIO&quot; on path: DexPathList[[zip file &quot;/data/app/~~uPm2D4x2H8UJPMnJkCz-fQ==/com.test.xxx-7vAaguDgQshpcmtUKuBo6g==/base.apk&quot;],nativeLibraryDirectories=[/data/app/~~uPm2D4x2H8UJPMnJkCz-fQ==/com.test.xxx-7vAaguDgQshpcmtUKuBo6g==/lib/arm64, /system/lib64]]        at dalvik.system.BaseDexClassLoader.findClass(BaseDexClassLoader.java:207)        at java.lang.ClassLoader.loadClass(ClassLoader.java:379)        at java.lang.ClassLoader.loadClass(ClassLoader.java:312)            ... 41 more    Enclosed exception:     java.lang.RuntimeException: Exception invoking drawImage        at net.sourceforge.htmlunit.corejs.javascript.MemberBox.invoke(MemberBox.java:238)        at net.sourceforge.htmlunit.corejs.javascript.FunctionObject.call(FunctionObject.java:405)        at net.sourceforge.htmlunit.corejs.javascript.Interpreter.interpretLoop(Interpreter.java:1876)        at net.sourceforge.htmlunit.corejs.javascript.Interpreter.interpret(Interpreter.java:1053)        at net.sourceforge.htmlunit.corejs.javascript.InterpretedFunction.call(InterpretedFunction.java:89)        at net.sourceforge.htmlunit.corejs.javascript.ContextFactory.doTopCall(ContextFactory.java:392)        at com.gargoylesoftware.htmlunit.javascript.HtmlUnitContextFactory.doTopCall(HtmlUnitContextFactory.java:335)        at net.sourceforge.htmlunit.corejs.javascript.ScriptRuntime.doTopCall(ScriptRuntime.java:3916)        at com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine$3.doRun(JavaScriptEngine.java:921)        at com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine$HtmlUnitContextAction.run(JavaScriptEngine.java:984)        at net.sourceforge.htmlunit.corejs.javascript.Context.call(Context.java:590)        at net.sourceforge.htmlunit.corejs.javascript.ContextFactory.call(ContextFactory.java:484)        at com.gargoylesoftware.htmlunit.javascript.HtmlUnitContextFactory.callSecured(HtmlUnitContextFactory.java:349)        at com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine.callFunction(JavaScriptEngine.java:928)        at com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine.callFunction(JavaScriptEngine.java:900)        at com.gargoylesoftware.htmlunit.html.HtmlPage.executeJavaScriptFunction(HtmlPage.java:2620)        at com.gargoylesoftware.htmlunit.html.HtmlPage.executeJavaScriptFunction(HtmlPage.java:2613)        at com.gargoylesoftware.htmlunit.javascript.host.event.EventListenersContainer.executeEventListeners(EventListenersContainer.java:342)        at com.gargoylesoftware.htmlunit.javascript.host.event.EventListenersContainer.executeAtTargetListeners(EventListenersContainer.java:379)        at com.gargoylesoftware.htmlunit.javascript.host.event.EventTarget.fireEvent(EventTarget.java:173)        at com.gargoylesoftware.htmlunit.html.DomElement.lambda$fireEvent$0(DomElement.java:1496)        at com.gargoylesoftware.htmlunit.html.DomElement$$ExternalSyntheticLambda0.run(Unknown Source:4)        at net.sourceforge.htmlunit.corejs.javascript.Context.call(Context.java:590)        at net.sourceforge.htmlunit.corejs.javascript.ContextFactory.call(ContextFactory.java:484)        at com.gargoylesoftware.htmlunit.javascript.HtmlUnitContextFactory.callSecured(HtmlUnitContextFactory.java:349)        at com.gargoylesoftware.htmlunit.html.DomElement.fireEvent(DomElement.java:1496)        at com.gargoylesoftware.htmlunit.html.HtmlImage.fireEvent(HtmlImage.java:949)        at com.gargoylesoftware.htmlunit.html.HtmlImage.doOnLoad(HtmlImage.java:319)        at com.gargoylesoftware.htmlunit.html.HtmlImage$1.execute(HtmlImage.java:165)        at com.gargoylesoftware.htmlunit.html.HtmlPage.initialize(HtmlPage.java:342)        at com.gargoylesoftware.htmlunit.WebClient.loadWebResponseInto(WebClient.java:710)2022-12-05 08:28:08.823 14255-14815/com.test.xxx E/JavaScriptErrorListener:     at com.gargoylesoftware.htmlunit.WebClient.loadWebResponseInto(WebClient.java:592)        at com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:510)        at com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:417)        at com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:555)        at com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:537)        at com.test.xxx.thread.PTCThread.run(PTCThread.java:58)     Caused by: java.lang.NoClassDefFoundError: Failed resolution of: Ljavax/imageio/ImageIO;        at com.gargoylesoftware.htmlunit.html.HtmlImage.readImageIfNeeded(HtmlImage.java:702)        at com.gargoylesoftware.htmlunit.html.HtmlImage.getImageReader(HtmlImage.java:619)        at com.gargoylesoftware.htmlunit.javascript.host.canvas.CanvasRenderingContext2D.drawImage(CanvasRenderingContext2D.java:410)        at java.lang.reflect.Method.invoke(Native Method)        at net.sourceforge.htmlunit.corejs.javascript.MemberBox.invoke(MemberBox.java:215)            ... 36 more     Caused by: java.lang.ClassNotFoundException: Didn't find class &quot;javax.imageio.ImageIO&quot; on path: DexPathList[[zip file &quot;/data/app/~~uPm2D4x2H8UJPMnJkCz-fQ==/com.test.xxx-7vAaguDgQshpcmtUKuBo6g==/base.apk&quot;],nativeLibraryDirectories=[/data/app/~~uPm2D4x2H8UJPMnJkCz-fQ==/com.test.xxx-7vAaguDgQshpcmtUKuBo6g==/lib/arm64, /system/lib64]]        at dalvik.system.BaseDexClassLoader.findClass(BaseDexClassLoader.java:207)        at java.lang.ClassLoader.loadClass(ClassLoader.java:379)        at java.lang.ClassLoader.loadClass(ClassLoader.java:312)            ... 41 more    == CALLING JAVASCRIPT ==      function () {          c.drawImage(a, 0, 0), Modernizr.addTest(&quot;todataurljpeg&quot;, function () {              return b.toDataURL(&quot;image/jpeg&quot;).indexOf(&quot;data:image/jpeg&quot;) === 0;          }), Modernizr.addTest(&quot;todataurlwebp&quot;, function () {              return b.toDataURL(&quot;image/webp&quot;).indexOf(&quot;data:image/webp&quot;) === 0;          });      }    ======= EXCEPTION END ========