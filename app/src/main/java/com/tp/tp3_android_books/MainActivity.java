package com.tp.tp3_android_books;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.tp.tp3_android_books.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private BookViewModel viewModel;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        viewModel = ViewModelProvider
                .AndroidViewModelFactory
                .getInstance(getApplication())
                .create(BookViewModel.class);

        adapter = new BookAdapter();
        binding.rvBooks.setAdapter(adapter);
        binding.rvBooks.setLayoutManager(new LinearLayoutManager(this));

        viewModel.getSearchResults().observe(this, books -> {
            adapter.setBooks(books);
        });

        viewModel.getToastMessage().observe(this, message -> {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        });

        binding.btnSearch.setOnClickListener( v -> {
            String query = binding.etSearchBook.getText().toString();
            viewModel.searchBook(query);
        });

        adapter.setOnItemClickListener(book -> {
            Intent intent = new Intent(MainActivity.this, DetailBookActivity.class);
            intent.putExtra("book_selected", book);
            startActivity(intent);
        });
    }
}