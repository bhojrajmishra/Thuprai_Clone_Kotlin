import android.content.Context

class SecureStorageService(private val context: Context) {
    private val sharedPreferences = context.getSharedPreferences(
        "secure_prefs",
        Context.MODE_PRIVATE
    )

    fun saveData(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getData(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    fun clearData() {
        sharedPreferences.edit().clear().apply()
    }
}