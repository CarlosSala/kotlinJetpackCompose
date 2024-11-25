package com.example.jetpackcompose.ui.screenexamples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Product(val name: String, val price: Double)
data class Advertising(val title: String)

private val listProducts = listOf(
    Product(name = "Apple", price = 18.99),
    Product(name = "Meat", price = 180.00),
    Product(name = "Milk", price = 24.50),
    Product(name = "Fish", price = 75.39),
    Product(name = "egg", price = 64.89),
    Product(name = "Cereal", price = 32.99),
    Product(name = "Orange", price = 28.50),
    Product(name = "Coffee", price = 72.00),
    Product(name = "Soap", price = 33.19),
    Product(name = "Oil", price = 19.00),
    Product(name = "Water", price = 55.99),
    Product(name = "Shirt", price = 228.49),
    Product(name = "Rice", price = 37.50),
    Product(name = "HERSHEY'S", price = 15.50),
    Product(name = "Honey", price = 82.00),
    Product(name = "Tuna", price = 16.90),
    Product(name = "Cookies", price = 41.00),
    Product(name = "Bread", price = 38.90),
    Product(name = "KitKat", price = 22.00),
    Product(name = "Crunch", price = 17.00),
)

private val listAdvertising = listOf(
    Advertising("Advertising 1"),
    Advertising("Advertising 2"),
    Advertising("Advertising 3"),
    Advertising("Advertising 4")
)

@Preview(showBackground = true)
@Composable
fun LazyColumnJC2() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Text(
                text = "Supermarket Products",
                style = TextStyle(
                    color = Color.Blue,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Black
                )
            )
        }
        /*items(listaProductos) {
            ProductoDiseño(producto = it)
        }*/
        itemsIndexed(listProducts) { position, product ->
            if (position % 5 == 0 && position != 0) {
                LazyRow {
                    items(listAdvertising) {
                        DesignAdvertising(advertising = it)
                    }
                }
            } else {
                DesignProduct(product = product)
            }
        }
    }
}

@Composable
fun DesignProduct(product: Product) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = product.name,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        )
        Text(
            text = "${product.price}.00 MXN",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            )
        )
    }
}

@Composable
fun DesignAdvertising(advertising: Advertising) {
    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .size(140.dp)
            .clip(RoundedCornerShape(12))
            .background(color = Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = advertising.title,
            style = TextStyle(
                fontWeight = FontWeight.Black
            )
        )
    }
}