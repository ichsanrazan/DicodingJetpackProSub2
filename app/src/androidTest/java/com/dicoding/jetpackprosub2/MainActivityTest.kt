package com.dicoding.jetpackprosub2

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dicoding.jetpackprosub2.utils.DataDummy
import com.dicoding.jetpackprosub2.utils.EspressoIdlingResource
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {

    private val dummyMovie = DataDummy.getMovies()
    private val dummyTvShow = DataDummy.getTvShows()

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movies))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.circleimage_movies))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre_duration))
                .check(matches(isDisplayed()))
        onView(withId(R.id.detail_name))
                .check(matches(isDisplayed()))

    }

    @Test
    fun loadTvShows() {
        onView(withText("TV SHOW"))
                .perform(click())
        onView(withId(R.id.rv_tv_shows))
                .check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV SHOW"))
                .perform(click())
        onView(withId(R.id.rv_tv_shows))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.circleimage_movies))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre_duration))
                .check(matches(isDisplayed()))
        onView(withId(R.id.detail_name))
                .check(matches(isDisplayed()))
    }
}