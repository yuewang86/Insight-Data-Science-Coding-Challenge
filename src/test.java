public class Test {

	public static void main(String[] args) {
		String inputFileName = "./tweet_input/tweets.txt";
		String outputFileName1 = "./tweet_output/ft1.txt";
		String outputFileName2 = "./tweet_output/ft2.txt";
		
		words_tweeted wt = new words_tweeted();
		wt.func(inputFileName, outputFileName1);
		
		median_unique mu = new median_unique();
		mu.func(inputFileName, outputFileName2);		
	}
}
