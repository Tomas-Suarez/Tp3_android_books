package com.tp.tp3_android_books;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;
import com.tp.tp3_android_books.databinding.ActivityDetailBookBinding;

import java.util.List;

public class DetailBookActivity extends AppCompatActivity {

    private ActivityDetailBookBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BookModel book = (BookModel) getIntent().getSerializableExtra("book_selected");

        if(book != null){
            binding.tvAuthor.setText(book.getAuthor());
            binding.tvPages.setText(String.valueOf(book.getPages()));
            binding.imageBook.setImageResource(book.getImageId());
            binding.tvYear.setText(String.valueOf(book.getYear()));
            binding.tvTitle.setText(book.getTitle());
            binding.tvSynopsis.setText(book.getSynopsis());
            genreView(book.getGenres());
        }

        binding.btnBack.setOnClickListener(v -> finish());
    }

    private void genreView(List<String> genres){
        if(genres == null){
            return;
        }

        binding.cGenre.removeAllViews();
        for(String genre : genres){
            Chip chip = new Chip(this);
            chip.setText(genre);

            chip.setClickable(false);
            chip.setCheckable(false);
            chip.setChipMinHeight(30f);
            chip.setTextSize(12f);

            binding.cGenre.addView(chip);
        }
    }
}