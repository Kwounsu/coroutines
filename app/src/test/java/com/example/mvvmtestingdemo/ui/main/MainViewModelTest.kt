package com.example.mvvmtestingdemo.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class MainViewModelTest {
    val testDispatcher = TestCoroutineDispatcher()

    lateinit var viewModel: MainViewModel
    @Mock
    lateinit var repo: MainRepo

    @get:Rule
    val instanceTasks = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MainViewModel(repo)
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun getResultObserver() {
        val check = viewModel.resultObserver.value == null
        assertEquals(true,check)
    }

    @Test
    fun getNewData() {
        runBlocking {
            val dummy = "12312412412"
            Mockito.`when`(repo.getData()).thenReturn(dummy)
            viewModel.getNewData()
            val result = viewModel.resultObserver.value

            println(result)
            assert(result != null)
        }
    }

    @Test
    fun testLengthEven() {
        assertEquals(true, viewModel.testLengthEven("1234"))
        assertEquals(false, viewModel.testLengthEven("123"))
    }
}