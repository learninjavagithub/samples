import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureExample {

	public static void main(String[] args) {

		new Thread(() -> {

			try {
				Thread.sleep(1000);
				System.out.println("Running from thread Normal Thread using Lamba...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		
		// START THREADS:
		// CompletableFuture using Void return type - use runAsync if no return type is required
		CompletableFuture<Void> vfuture = CompletableFuture.runAsync(() -> {

			try {
				Thread.sleep(1000);
				System.out.println("Running from thread with Void return type...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		try {
			vfuture.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		// CompletableFuture using Void return type - use supplyAsync if return type is required
		CompletableFuture<String> sfuture = CompletableFuture.supplyAsync(new Supplier<String>() {

			@Override
			public String get() {
				try {
					Thread.sleep(1000);
					System.out.println("Running from thread with String return type...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return "SUCCESS";
			}

		});

		try {
			System.out.println("The string result is : " + sfuture.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		// OR Using Lambas:
		
		// CompletableFuture using Void return type - use supplyAsync if return type is required
		CompletableFuture<String> slfuture = CompletableFuture.supplyAsync(() -> {

			try {
				Thread.sleep(1000);
				System.out.println("Running from thread with String return type with Lambas...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "LSUCCESS";

		});

		try {
			System.out.println("The string result with lambas is : " + slfuture.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		// THEN : - .get() is blocking so we attach call backs which is achieved using "thenXyz()" methods

		// thenApply() - to transform the output
		CompletableFuture<String> thenApplyFuture = CompletableFuture.supplyAsync(() -> {

			try {
				Thread.sleep(1000);
				System.out.println("Running from thread using \"then\"...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "SUCCESS";

		}).thenApply(status -> {
			
			return "STATUS CODE IS: " + status;
		}).thenApply(result -> {
			
			return result + " ERROR CODE: 404";
		});

		// Block the thread and display output - this is required
		try {
			System.out.println(thenApplyFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		// thenAccept() - if dont want to return anything but want to run a piece of code with access to the result
		// There is no blocking to wait for the result so removed the sleep method
		CompletableFuture.supplyAsync(() -> {

			System.out.println("Running from thread using \"then\"...");
			return "SUCCESS";

		}).thenAccept(status -> {
		
			System.out.println("Comsume the result and do some process: " + status);
		});


		// thenRun() - if dont want to return anything but want to run a piece of code without access to the result
		// There is no blocking to wait for the result so removed the sleep method
		CompletableFuture.supplyAsync(() -> {

			System.out.println("Running from thread using \"then\"...");
			return "SUCCESS";

		}).thenRun(() -> {
		
			System.out.println("Just do some process");
		});

		//thenCombine - combines results of two CompletableFutures. Returns CompletableFuture
		CompletableFuture<String> combineFuture = sfuture.thenCombine(slfuture, (s1, s2) -> s1 + "|" + s2);
		System.out.println(combineFuture.getNow(null));
		
		//thenCompose - combines results of two CompletableFutures. Returns CompletableFuture
		CompletableFuture<String> composeFuture1 = new CompletableFutureExample().getUserName().thenCompose(new CompletableFutureExample()::getDept);
		try {
			System.out.println("Results of combine is: " + composeFuture1.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	public CompletableFuture<String> getUserName() {
		
		CompletableFuture<String> sfuture = CompletableFuture.supplyAsync(new Supplier<String>() {

			@Override
			public String get() {
				try {
					Thread.sleep(1000);
					System.out.println("Running from compose thread1...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return "GAN";
			}

		});
		return sfuture;
	}
	
	public  CompletableFuture<String> getDept(String name) {
		
		CompletableFuture<String> sfuture = CompletableFuture.supplyAsync(new Supplier<String>() {

			@Override
			public String get() {
				try {
					Thread.sleep(1000);
					System.out.println("Running from compose thread2...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return "1";
			}

		});
		
		return sfuture;
	}
	
	
}
