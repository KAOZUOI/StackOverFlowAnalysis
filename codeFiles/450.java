package com.api;import jakarta.ws.rs.GET;import jakarta.ws.rs.Path;import jakarta.ws.rs.Produces;import jakarta.ws.rs.core.MediaType;@Path(&quot;myresource&quot;)public class Ressources {                @GET        @Produces(MediaType.TEXT_PLAIN)        public String sayHello(){            return  &quot;say Hello&quot;;        }    }