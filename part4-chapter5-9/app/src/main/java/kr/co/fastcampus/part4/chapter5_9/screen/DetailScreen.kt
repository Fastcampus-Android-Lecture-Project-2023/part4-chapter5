package kr.co.fastcampus.part4.chapter5_9.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import kr.co.fastcampus.part4.chapter5_9.viewmodel.PokemonViewModel

// 단계 1: viewModel을 제대로 설정하자. `hiltViewModel()`를 사용한다.
@Composable
fun DetailScreen(
    pokemonId: Int,
    onUpButtonClick: () -> Unit,
    viewModel: PokemonViewModel = hiltViewModel()
) {
    viewModel.getPokemon(pokemonId)

    Card(
        elevation = 8.dp,
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            val result = viewModel.pokemonResult
            val pokemonName = result.species.name

            Text(pokemonName)

            AsyncImage(
                model = result.sprites.frontDefault,
                contentDescription = pokemonName,
                modifier = Modifier.size(100.dp)
            )

            Button(onClick = onUpButtonClick) {
                Text("위로")
            }
        }
    }
}