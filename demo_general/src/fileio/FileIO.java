package fileio;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

	public static void main(String[] args) {

		String filename = "Info.dat";
		File file = new File(filename);
		String filenameWrite = "NewInfo.dat" ;
		File fileWrite = new File(filenameWrite) ;

		showFileInputStream(filename, file);	// byte stream read
		showBufferedInputStream(filename, file);	// buffered byte stream read
		showFileReader(filename, file);	// character stream read
		showBufferedReader(filename, file);	// buffered character read lines
		showFileOutputStream(filename, file, filenameWrite, fileWrite);	// byte stream write
		showBufferedWriter(filename, file, filenameWrite, fileWrite ) ;	// buffered character writer line
		showPathFile7( filename, filenameWrite ) ;

	}

	private static void showFileInputStream(String filename, File file) {
		try (FileInputStream fis = new FileInputStream(file)) {
			byte[] bytes = new byte[10];
			int rc = 0;
			rc = fis.read(bytes);
			while (rc != -1) {
				for (byte b : bytes) {
					System.out.println("Byte = " + b + " Char = '" + (char) b + "'");
				}
				rc = fis.read(bytes);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void showBufferedInputStream(String filename, File file) {
		try (FileInputStream fis = new FileInputStream(file); BufferedInputStream bis = new BufferedInputStream(fis)) {
			int b;
			b = bis.read();
			while (b != -1) {
				System.out.println("Byte = " + b + " Char = '" + (char) b + "'");
				b = bis.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void showFileReader(String filename, File file) {
		try ( FileReader fr = new FileReader (file) ) {
			char[] chars = new char[10];
			int rc = 0;
			rc = fr.read(chars);
			while (rc != -1) {
				for (char c : chars) {
					System.out.println("Char = '" + c + "'");
				}
				rc = fr.read(chars);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void showBufferedReader(String filename, File file) {
		try ( FileReader fr = new FileReader(file) ; BufferedReader br = new BufferedReader ( fr )) {
			String line = br.readLine() ;
			while ( line != null ) {
				System.out.println("Line = " + line );
				line = br.readLine() ;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void showFileOutputStream(String filename, File file, String filenameWrite, File fileWrite) {
		try (
			FileOutputStream fos = new FileOutputStream(fileWrite) ;
			FileInputStream fis = new FileInputStream(file);
				) {
			byte[] bytesRead = new byte[10] ;
			byte[] bytesWrite = new byte[10] ;
			fis.read(bytesRead) ;
			for ( int i = 0 ; i < 10 ; i++ ) {
				byte b = bytesRead[i] ;
				bytesWrite[i] = ++b ;
			}
			fos.write(bytesWrite);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void showBufferedWriter(String filename, File file, String filenameWrite, File fileWrite) {
		try ( FileReader fr = new FileReader(file) ;
			BufferedReader br = new BufferedReader ( fr ) ;
			FileWriter fw = new FileWriter(fileWrite) ;
			BufferedWriter bw = new BufferedWriter(fw);
		) {
			String line = br.readLine() ;
			while ( line != null ) {
				String firstChar = line.substring(0, 1) ;
				if ( firstChar.equals("A")) {
					line = line.toLowerCase();
				} else {
					line = line.toUpperCase() ;
				}
				bw.write(line);
				bw.write("\n");
				line = br.readLine() ;
			}
			bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void showPathFile7(String filename , String filenameWrite) {

		try {
			URI uriRead = new URI (filename ) ;
			URI uriWrite = new URI (filenameWrite ) ;
			Path pRead = Paths.get(filename);
			Path pWrite = Paths.get(filenameWrite);
			List<String> lines;
			lines = Files.readAllLines(pRead);
			List<String> newLines = new ArrayList<>();
			for ( String line : lines ) {
				newLines.add(line);
			}
			Files.write(pWrite, newLines) ;
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}













}
