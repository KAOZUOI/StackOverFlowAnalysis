class KtNonsense {    companion object {        fun doTheThing(mapView: MapView, act: AppCompatActivity) {            val locationComponentPlugin = mapView.location            locationComponentPlugin.updateSettings {                this.enabled = true                this.locationPuck = LocationPuck2D(                        bearingImage = AppCompatResources.getDrawable(                                act, //this@LocationTrackingActivity,                                R.drawable.mapbox_user_puck_icon,                        ),                        shadowImage = AppCompatResources.getDrawable(                                act, //this@LocationTrackingActivity,                                R.drawable.mapbox_user_icon_shadow,                        ),                        scaleExpression = interpolate {                            linear()                            zoom()                            stop {                                literal(0.0)                                literal(0.6)                            }                            stop {                                literal(20.0)                                literal(1.0)                            }                        }.toJson()                )            }        }    }}