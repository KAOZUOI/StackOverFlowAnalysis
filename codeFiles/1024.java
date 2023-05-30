package io.swagger.pipelinerequest;import com.fasterxml.jackson.annotation.JsonSubTypes;import com.fasterxml.jackson.annotation.JsonTypeInfo;/*** PipelineTask*/@JsonTypeInfo(  use = JsonTypeInfo.Id.NAME,  include = JsonTypeInfo.As.PROPERTY,  property = &quot;taskType&quot;)@JsonSubTypes({  @JsonSubTypes.Type(value = TranslationTask.class, name = &quot;translation&quot;),  @JsonSubTypes.Type(value = ASRTask.class, name = &quot;asr&quot;),  @JsonSubTypes.Type(value = TTSTask.class, name = &quot;tts&quot;)})public interface PipelineTask {    SupportedTasks getTaskType();}