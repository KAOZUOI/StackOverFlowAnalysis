EducationItemBody body = new EducationItemBody();body.content = message;body.contentType = BodyType.TEXT;EducationFeedback feedback = new EducationFeedback();feedback.text = body;EducationFeedbackOutcome outcome = new EducationFeedbackOutcome();outcome.feedback = feedback;outcome.publishedFeedback = feedback;