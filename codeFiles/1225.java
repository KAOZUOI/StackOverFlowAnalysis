    with(binding) {        searchView            .editText            .setOnEditorActionListener { v, actionId, event ->                searchBar.text = searchView.text                searchView.hide()                false            }    }