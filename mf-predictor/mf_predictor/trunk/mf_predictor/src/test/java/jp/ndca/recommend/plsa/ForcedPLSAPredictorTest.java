package jp.ndca.recommend.plsa;

import java.io.IOException;

import jp.ndca.recommend.common.data.RatingDataset;
import jp.ndca.recommend.common.util.Evaluator;
import jp.ndca.test.MovieLensDataHandler;

import org.junit.Test;

public class ForcedPLSAPredictorTest {

	@Test
	public void cvTest() throws NumberFormatException, IOException{

		RatingDataset[] trainingDataset = MovieLensDataHandler.get5FolodTrainingData();
		RatingDataset[] testDataset = MovieLensDataHandler.get5FolodTestData();
		
		System.out.println("learn start!");
		long start = System.currentTimeMillis();
		ForcedPLSALearner plsa = new ForcedPLSALearner();
		plsa.setK(50);
		plsa.setMinVar(0.01);
		//plsa.setThreadNum(2);
		plsa.setEta(0.9);
		plsa.setMaxIteration(10);
		plsa.setTestConvergence(true);

		Evaluator.cvTest(trainingDataset, testDataset, plsa );
		long end = System.currentTimeMillis();
		System.out.println( (end - start) + " ms");
		
		// MAE  : 0.7424379689586948
		// RSME : 0.9426361811518429		
		// 6843 ms
		
	}

}
