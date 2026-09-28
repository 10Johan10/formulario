package com.example.myapplication
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    // Variables para los campos de texto
    var nombre by remember { mutableStateOf("") }
    var matricula by remember { mutableStateOf("") }
    var asignatura by remember { mutableStateOf("") }
    var hora by remember { mutableStateOf("") }
    var fechaEntrega by remember { mutableStateOf("") }

    // Variables para controlar el estado de error de cada campo
    var errorNombre by remember { mutableStateOf(false) }
    var errorMatricula by remember { mutableStateOf(false) }
    var errorAsignatura by remember { mutableStateOf(false) }
    var errorHora by remember { mutableStateOf(false) }
    var errorFecha by remember { mutableStateOf(false) }

    // Variables para guardar y mostrar los datos en la Card
    var guardarNombre by remember { mutableStateOf("") }
    var guardarMatricula by remember { mutableStateOf("") }
    var guardarAsignatura by remember { mutableStateOf("") }
    var guardarHora by remember { mutableStateOf("") }
    var guardarFecha by remember { mutableStateOf("") }
    var mostrarCard by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(text = "Formulario de Registro")

        Spacer(modifier = Modifier.height(10.dp))

        // 1. Campo Nombre
        Text(text = "Nombre:")
        TextField(
            value = nombre,
            onValueChange = {
                nombre = it
                if (it.isNotBlank()) errorNombre = false
            },
            isError = errorNombre,
            modifier = Modifier.fillMaxWidth()
        )
        if (errorNombre) {
            Text(text = "Este campo es obligatorio", color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(10.dp))

        // 2. Campo Matrícula (Solo números)
        Text(text = "Matrícula:")
        TextField(
            value = matricula,
            onValueChange = {
                matricula = it
                if (it.isNotBlank()) errorMatricula = false
            },
            isError = errorMatricula,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        if (errorMatricula) {
            Text(text = "Este campo es obligatorio", color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(10.dp))

        // 3. Campo Asignatura
        Text(text = "Asignatura:")
        TextField(
            value = asignatura,
            onValueChange = {
                asignatura = it
                if (it.isNotBlank()) errorAsignatura = false
            },
            isError = errorAsignatura,
            modifier = Modifier.fillMaxWidth()
        )
        if (errorAsignatura) {
            Text(text = "Este campo es obligatorio", color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(10.dp))

        // 4. Campo Hora que se imparte
        Text(text = "Hora que se imparte:")
        TextField(
            value = hora,
            onValueChange = {
                hora = it
                if (it.isNotBlank()) errorHora = false
            },
            isError = errorHora,
            modifier = Modifier.fillMaxWidth()
        )
        if (errorHora) {
            Text(text = "Este campo es obligatorio", color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(10.dp))

        // 5. Campo Fecha de entrega
        Text(text = "Fecha de entrega:")
        TextField(
            value = fechaEntrega,
            onValueChange = {
                fechaEntrega = it
                if (it.isNotBlank()) errorFecha = false
            },
            isError = errorFecha,
            modifier = Modifier.fillMaxWidth()
        )
        if (errorFecha) {
            Text(text = "Este campo es obligatorio", color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(15.dp))

        // Botón de guardado con validación
        Button(
            onClick = {
                // Revisamos si cada campo está vacío
                errorNombre = nombre.isBlank()
                errorMatricula = matricula.isBlank()
                errorAsignatura = asignatura.isBlank()
                errorHora = hora.isBlank()
                errorFecha = fechaEntrega.isBlank()

                // Si NINGÚN campo tiene error, mostramos la Card
                if (!errorNombre && !errorMatricula && !errorAsignatura && !errorHora && !errorFecha) {
                    guardarNombre = nombre
                    guardarMatricula = matricula
                    guardarAsignatura = asignatura
                    guardarHora = hora
                    guardarFecha = fechaEntrega
                    mostrarCard = true
                } else {
                    mostrarCard = false
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Guardar")
        }

        Spacer(modifier = Modifier.height(15.dp))

        // Card en la parte inferior para mostrar los datos ingresados
        if (mostrarCard) {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "Datos Registrados")
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Nombre: $guardarNombre")
                    Text(text = "Matrícula: $guardarMatricula")
                    Text(text = "Asignatura: $guardarAsignatura")
                    Text(text = "Hora: $guardarHora")
                    Text(text = "Fecha de entrega: $guardarFecha")
                }
            }
        }
    }
}