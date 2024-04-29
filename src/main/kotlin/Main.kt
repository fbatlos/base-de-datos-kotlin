import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.sql.DriverManager
import java.sql.SQLException

@Composable
@Preview
fun App(text:String) {

    MaterialTheme {

            Text(text)

    }
}

fun main() = application {
    var url = "jdbc:mysql://localhost:3306/studentdb"
    val usuario = "studentuser"
    val password = "password"

    var texto = ""

    try {
        Class.forName("com.mysql.cj.jdbc.Driver")
        val conexion = DriverManager.getConnection(url,usuario,password)

        texto = "conexion exitosa"
        conexion.close()
    }catch (e:SQLException){
        texto = "ERROR coxion = ${e.message}"
    } catch (e:ClassNotFoundException ){
        texto = "ERROR sql = ${e.message}"
    }

    Window(onCloseRequest = ::exitApplication) {
        App(texto)
    }
}
