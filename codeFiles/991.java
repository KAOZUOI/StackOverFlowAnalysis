private fun initLocationComponent() {    val locationComponentPlugin = mapView.location    locationComponentPlugin.updateSettings {        this.enabled = true        this.locationPuck = ...    }    // ...}