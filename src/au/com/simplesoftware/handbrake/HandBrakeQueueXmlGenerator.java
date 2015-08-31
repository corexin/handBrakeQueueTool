package au.com.simplesoftware.handbrake;

import java.io.File;
import java.text.MessageFormat;

public class HandBrakeQueueXmlGenerator {
	public static final String header = "<?xml version=\"1.0\"?><ArrayOfQueueTask xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">";
	
	public static final String repeatedHeader = "<QueueTask><Status>Waiting</Status><Task><OptimizeMP4>false</OptimizeMP4><IPod5GSupport>false</IPod5GSupport><VideoBitrate xsi:nil=\"true\" /><AudioTracks><AudioTrack><Bitrate>160</Bitrate><DRC>0</DRC><IsDefault>false</IsDefault><Encoder>ffaac</Encoder><Gain>0</Gain><MixDown>DolbyProLogicII</MixDown><SampleRate>0</SampleRate><SampleRateDisplayValue>Auto</SampleRateDisplayValue><ScannedTrack><TrackNumber>1</TrackNumber><Language>English</Language><LanguageCode>eng</LanguageCode><Description>English (AAC) (2.0 ch)</Description><Format /><SampleRate>48000</SampleRate><Bitrate>96022</Bitrate></ScannedTrack><TrackName /></AudioTrack></AudioTracks><AllowedPassthruOptions><AudioAllowAACPass>true</AudioAllowAACPass><AudioAllowAC3Pass>true</AudioAllowAC3Pass><AudioAllowDTSHDPass>true</AudioAllowDTSHDPass><AudioAllowDTSPass>true</AudioAllowDTSPass><AudioAllowMP3Pass>true</AudioAllowMP3Pass><AudioEncoderFallback>Ac3</AudioEncoderFallback></AllowedPassthruOptions><SubtitleTracks /><ChapterNames><ChapterMarker><ChapterNumber>1</ChapterNumber><Duration /><ChapterName>Chapter 1</ChapterName></ChapterMarker></ChapterNames>";
	public static final String repeatedItem ="<Source>{0}</Source><Title>1</Title><Angle>1</Angle><PointToPointMode>Chapters</PointToPointMode><StartPoint>1</StartPoint><EndPoint>1</EndPoint><Destination>{1}.m4v</Destination>";
	public static final String repeatedTailer = "<OutputFormat>Mp4</OutputFormat><Width>1280</Width><Height>0</Height><MaxWidth xsi:nil=\"true\" /><MaxHeight xsi:nil=\"true\" /><Cropping><Top>0</Top><Bottom>0</Bottom><Left>0</Left><Right>0</Right></Cropping><HasCropping>false</HasCropping><Anamorphic>Loose</Anamorphic><DisplayWidth xsi:nil=\"true\" /><KeepDisplayAspect>false</KeepDisplayAspect><PixelAspectX>0</PixelAspectX><PixelAspectY>0</PixelAspectY><Modulus>2</Modulus><Deinterlace>Off</Deinterlace><Decomb>Off</Decomb><Detelecine>Off</Detelecine><Denoise>Off</Denoise><DenoisePreset>Weak</DenoisePreset><DenoiseTune>None</DenoiseTune><Deblock>4</Deblock><Grayscale>false</Grayscale><VideoEncodeRateType>ConstantQuality</VideoEncodeRateType><VideoEncoder>X264</VideoEncoder><FramerateMode>VFR</FramerateMode><Quality>20</Quality><TwoPass>false</TwoPass><TurboFirstPass>false</TurboFirstPass><Framerate xsi:nil=\"true\" /><IncludeChapterMarkers>true</IncludeChapterMarkers><X264Preset>VeryFast</X264Preset><QsvPreset>Quality</QsvPreset><H264Profile>Main</H264Profile><H264Level>4.0</H264Level><X264Tune>None</X264Tune><FastDecode>false</FastDecode><X265Preset>VeryFast</X265Preset><H265Profile>None</H265Profile><X265Tune>None</X265Tune><PreviewStartAt xsi:nil=\"true\" /><PreviewDuration xsi:nil=\"true\" /><IsPreviewEncode>false</IsPreviewEncode><PreviewEncodeDuration>0</PreviewEncodeDuration><ShowAdvancedTab>false</ShowAdvancedTab>	</Task><Configuration><IsLoggingEnabled>true</IsLoggingEnabled><IsDvdNavDisabled>false</IsDvdNavDisabled><DisableQuickSyncDecoding>false</DisableQuickSyncDecoding><EnableDxva>false</EnableDxva><ScalingMode>Lanczos</ScalingMode><PreviewScanCount>10</PreviewScanCount><Verbosity>1</Verbosity><MinScanDuration>10</MinScanDuration><ProcessPriority>Below Normal</ProcessPriority><SaveLogToCopyDirectory>false</SaveLogToCopyDirectory><SaveLogWithVideo>false</SaveLogWithVideo><SaveLogCopyDirectory /></Configuration></QueueTask>";
	
	public static final String tailer = "</ArrayOfQueueTask>";
	
	public static final String filePath = "E:\\tmp\\video";
	
	public static void main(String[] args) {
		
		System.out.println(header);
		File[] list = new File(filePath).listFiles();
		for(File file: list)
		{
			System.out.println(repeatedHeader);
			String absolutePath = file.getAbsolutePath();
			String format = MessageFormat.format(repeatedItem, absolutePath, absolutePath.replace(".mp4", ""));
			System.out.println(format);
			System.out.println(repeatedTailer);
		}
		System.out.println(tailer);
	}
}
