function patchDemo() {    var doc = {        &quot;id&quot;: &quot;exampleDoc&quot;,        &quot;fields&quot;: {            &quot;field1&quot;: &quot;exampleString&quot;,            &quot;field2&quot;: 20,            &quot;field3&quot;: 40        }    };        var isAccepted = __.createDocument(__.getSelfLink(), doc, (err, doc) => {        if (err) {            throw err;        }        else {            getContext().getResponse().setBody(&quot;Example document successfully created.&quot;);                        var patchSpec = [                { &quot;op&quot;: &quot;add&quot;, &quot;path&quot;: &quot;/fields/field1&quot;, &quot;value&quot;: &quot;newExampleString&quot; },                { &quot;op&quot;: &quot;remove&quot;, &quot;path&quot;: &quot;/fields/field2&quot; },                { &quot;op&quot;: &quot;incr&quot;, &quot;path&quot;: &quot;/fields/field3&quot;, &quot;value&quot;: 10 }            ];                        var isAccepted = __.patchDocument(doc._self, patchSpec, (err, doc) => {                if (err) {                    throw err;                }                else {                    getContext().getResponse().appendBody(&quot; Example document successfully patched.&quot;);                }            });                        if (!isAccepted) throw new Error(&quot;Patch wasn't accepted&quot;);        }    });    if (!isAccepted) throw new Error(&quot;Create wasn't accepted.&quot;);}