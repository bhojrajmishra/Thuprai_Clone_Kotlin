import android.content.Context
import android.content.SharedPreferences

public class SecureStorageService(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("secure_storage", Context.MODE_PRIVATE)

    fun saveData(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getData(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    fun deleteData(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    companion object {
        private var instance: SecureStorageService? = null

        fun getInstance(context: Context): SecureStorageService {
            if (instance == null) {
                instance = SecureStorageService(context)
            }
            return instance!!
        }
    }
}