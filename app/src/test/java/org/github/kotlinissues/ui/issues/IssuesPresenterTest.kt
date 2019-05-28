package org.github.kotlinissues.ui.issues

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.github.kotlinissues.RxImmediateSchedulerRule
import org.github.kotlinissues.data.DataRepository
import org.github.kotlinissues.data.IDataRepository
import org.github.kotlinissues.model.Issue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations


class IssuesPresenterTest {

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    @Mock
    private lateinit var view: IssuesContract.View

    lateinit var mPresenter: IssuesPresenter

    @Mock
    lateinit var mockDataRepository: IDataRepository


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mPresenter = IssuesPresenter(view, mockDataRepository)
    }

    @Test
    fun subscribe() {
        val issues:List<Issue>  = mock()
        whenever(mockDataRepository.getKotlinIssues())
            .thenReturn(Observable.just(issues))
        mPresenter.subscribe()
        verify(view, times(1)).showError(false)
        verify(view, times(1)).setLoadingIndicator(true)
    }

    @Test
    fun subscribeWithLoadError() {
        whenever(mockDataRepository.getKotlinIssues())
            .thenReturn(Observable.error( Exception()))
        mPresenter.subscribe()
        verify(view, times(1)).showError(false)
        verify(view, times(1)).setLoadingIndicator(true)
        verify(view, times(1)).setLoadingIndicator(false)
        verify(view, times(1)).showError(true)
    }

    @Test
    fun unsubscribe() {
    }
}