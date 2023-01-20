package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e_commerce.adapter.CategoryAdapter;
import com.example.e_commerce.adapter.CourseAdapter;
import com.example.e_commerce.model.Category;
import com.example.e_commerce.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    //followed by  static method shoeCourseCategory
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCoursesList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Игры"));
        categoryList.add(new Category(2, "Сайты"));
        categoryList.add(new Category(3, "Языки"));
        categoryList.add(new Category(4, "Прочее"));

    setCategoryRecycler(categoryList);


        courseList.add(new Course(1, "java_2", "Профессия Java\nразработчик", "1 января", "Начинающий", "#424345", "test", 3));
        courseList.add(new Course(2, "python", "Профессия Python\nразработчик", "2 января", "Средний", "#9FA52D","test", 3));
        courseList.add(new Course(3, "unity", "Профессия Unity\nразработчик", "15 января", "Начинающий", "#65173D", "test", 1));
        courseList.add(new Course(4, "front_end", "Профессия Front-end\nразработчик", "18 марта", "Средний", "#B04935", "test", 2));
        courseList.add(new Course(5, "back_end", "Профессия Back-end\nразработчик", "7 марта", "Средний", "#2D55A5", "test",2));
        courseList.add(new Course(6, "full_stack", "Профессия Full Stack\nразработчик", "9 мая", "Средний", "#FFC007", "test", 2));

        fullCoursesList.addAll(courseList);
        setCourseRecycler(courseList);

    }

    public void openShoppingCart(View view)  {
    Intent intent = new Intent(this, OrderPage.class);
    startActivity(intent);
    }

    private void setCourseRecycler(List<Course> courseList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    //set horizontal view  for categories
    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }


    //filtration of courses
    public static void showCoursesByCategory(int category){
        courseList.clear();
        courseList.addAll(fullCoursesList);

    List<Course> filterCourses = new ArrayList<>();

    for(Course c: courseList) {
        if(c.getCategory() == category)
            filterCourses.add(c);
    }

    courseList.clear();
    courseList.addAll(filterCourses);

    courseAdapter.notifyDataSetChanged();
    }
}