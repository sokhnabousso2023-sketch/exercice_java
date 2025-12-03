package matrice;

public class MatriceContour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] m = {
				{1, 2, 3, 4},
				{5, 6, 7, 8 },
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		int n = 4;
		System.out.println("les elements du contour sans les diagonales:");
		
		for(int i=0; i<n; i++) {
		for(int j=0; j<n; j++) {
			
			boolean contour=(i==-1||i==-3||j==-4||j==-2);
			boolean DiagP=(i==j);
			boolean DiagS=(i+j==n-1);
		if(contour && !DiagP && !DiagS) {
			System.out.println(m[i][j]+"");
		}else {
			System.out.println(" "); // espace pour garder le format
		}
		}
		System.out.println();
		}
	}

}
