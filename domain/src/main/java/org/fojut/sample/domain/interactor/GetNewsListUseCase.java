package org.fojut.sample.domain.interactor;

import org.fojut.sample.data.service.NewsApiService;
import org.fojut.sample.domain.executor.PostExecutionThread;
import org.fojut.sample.domain.executor.ThreadExecutor;
import org.fojut.sample.domain.interactor.base.UseCase;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by fojut on 2016/4/20.
 */
public class GetNewsListUseCase extends UseCase {

    @Inject
    public GetNewsListUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    @Override
    protected Observable buildUseCaseObservable(Object ...params) {
        return NewsApiService.getInstance().getNewsList((String) params[0], (String) params[1], (int) params[2], (int) params[3]);
    }
}
