package eu.nts.nmp.csm.mac.api.generated.endpoint.avl;import eu.nts.nmp.csm.mac.api.generated.model.avl.ErrorDto;import java.time.LocalDate;import eu.nts.nmp.csm.mac.api.generated.model.avl.ResponseListMaintenanceWindowAVRDto;import javax.ws.rs.*;import javax.ws.rs.core.Response;import java.io.InputStream;import java.util.Map;import java.util.List;import javax.validation.constraints.*;import javax.validation.Valid;@Path(&quot;/maintenance-windows-avr/{day}&quot;)@javax.annotation.Generated(value = &quot;org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen&quot;, date = &quot;2023-03-14T16:46:37.723499+01:00[Europe/Vienna]&quot;)public interface MaintenanceWindowsAvrApi {    @GET    @Produces({ &quot;application/json&quot; })    Response getMaintenanceWindows(@PathParam(&quot;day&quot;) LocalDate day);}