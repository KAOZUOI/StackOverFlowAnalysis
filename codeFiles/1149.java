  val emitFailureHandler = EmitFailureHandler { _: SignalType?, emitResult: EmitResult ->    (emitResult == EmitResult.FAIL_NON_SERIALIZED || emitResult == EmitResult.FAIL_OVERFLOW)  }