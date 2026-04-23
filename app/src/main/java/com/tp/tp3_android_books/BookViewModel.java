package com.tp.tp3_android_books;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BookViewModel extends AndroidViewModel {
    private final MutableLiveData<String> toastMessage;
    private final MutableLiveData<List<BookModel>> bookMutable;
    private final MutableLiveData<List<BookModel>> searchResultsMutable;

    public BookViewModel(@NonNull Application application) {
        super(application);
        toastMessage = new MutableLiveData<>();
        bookMutable = new MutableLiveData<>();
        searchResultsMutable = new MutableLiveData<>();
        initValueTest();
    }

    // Cargamos datos de prueba
    private void initValueTest(){
        List<BookModel> init = Arrays.asList(
                new BookModel(
                        UUID.randomUUID(),
                        "El Hobbit",
                        "J.R.R. Tolkien",
                        310,
                        1937,
                        Arrays.asList("Fantasia", "Aventura"),
                        "Un hobbit llamado Bilbo Bolsón emprende una aventura inesperada junto a un grupo de enanos para recuperar un tesoro custodiado por un dragón.",
                        R.drawable.portada_hobbit
                        ),
                new BookModel(
                        UUID.randomUUID(),
                        "Drácula",
                        "Bram Stoker",
                        418,
                        1897,
                        Arrays.asList("Terror", "Novela Gótica", "Fantasía"),
                        "La clásica historia del vampiro de Transilvania que viaja a Inglaterra para esparcir la maldición de los no muertos.",
                        R.drawable.portada_dracula
                        ),
                new BookModel(
                        UUID.randomUUID(),
                        "1984",
                        "George Orwell",
                        328,
                        1949,
                        Arrays.asList("Ciencia Ficción", "Distopía"),
                        "En un futuro totalitario, Winston Smith intenta rebelarse contra la vigilancia opresiva del Gran Hermano.",
                        R.drawable.portada_1984
                )
        );
        // Mutable donde tenemos cargados los libros de prueba
        bookMutable.setValue(init);
    }


    // Mutable para una lista de resultados filtrados segun la busqueda
    public LiveData<List<BookModel>> getSearchResults() {
        return searchResultsMutable;
    }

    // Mutable para enviar los mensajes de texto
    public LiveData<String> getToastMessage(){
        return toastMessage;
    }

    // Metodo para filtrar la lista por el autor o por el titulo
    public void searchBook(String query){
        try{
            List<BookModel> list = bookMutable.getValue();

            if(list == null || query.isEmpty()){
                toastMessage.setValue("El campo no se puede encontrar vacio!");
                Log.d("ModelView", "searchBook: El campo se encuentra vacio.");
                return;
            }

            String search = query.toLowerCase().trim();

            List<BookModel> filters = list.stream()
                    .filter(b ->
                                    b.getTitle().toLowerCase().contains(search) ||
                                    b.getAuthor().toLowerCase().contains(search)
                    )
                    .collect(Collectors.toList());

            if(filters.isEmpty()) {
                toastMessage.setValue("No se encontraron resultados...");
            }

            // Actualizamos el mutable
            searchResultsMutable.setValue(filters);

        }catch (Exception e){
            Log.e("ModelView", "Error: " + e.getMessage());
        }
    }

}
