현재 이 프로젝트는 배포하고 있지 않습니다.

## 기술 스택

### Frontend
<table>
	<tr>
		<td>
			<image src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566879300/noticon/fvty9lnsbjol5lq9u3by.svg" width="80px" height="80px"/>		
		</td>
	  	<td>
			<image src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566913457/noticon/eh4d0dnic4n1neth3fui.png" width="80px" height="80px"/>			
		</td>
	  	<td>
			<image src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1691760811/noticon/mj67k1iwrb1vjrrntob2.png" width="80px" height="80px"/>
		</td>
	  	<td>
			<image src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566919941/noticon/bwij1af50rjj0fiyjtci.png" width="80px" height="80px"/>
		</td>	
	</tr>
	<tr>
		<td>Next.js</td>
	  	<td>Typescript</td>
	  	<td>SWR</td>
	  	<td>Redux toolkit</td>	
	</tr>
</table>

### Backend
<table>
	<tr>
		<td>
			<image src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1567008187/noticon/m4oad4rbf65fjszx0did.png" width="80px" height="80px"/>		
		</td>
	  	<td>
			<image src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1686935854/noticon/r7w1ipwmdmhlfzqfw69h.png" width="80px" height="80px"/>			
		</td>
	  	<td>
			<image src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1687307488/noticon/o9lxyva5z8zbwyeaxers.png" width="80px" height="80px"/>
		</td>
	</tr>
	<tr>
		<td>Spring boot</td>
	  	<td>Spring security</td>
	  	<td>Spring Data JPA</td>	
	</tr>
</table>

### Database
<table>
	<tr>
		<td>
			<image src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1566913591/noticon/e2bd9zw78n6zw6his4bd.png" width="80px" height="80px"/>		
		</td>
	</tr>
	<tr>
		<td>Mysql</td>
	</tr>
</table>

### DevOps
<table>
	<tr>
		<td>
			<image src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1629987467/noticon/o0ua9qgyuuoazjqwwvas.png" width="80px" height="80px"/>		
		</td>
		<td>
			<image src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1683592944/noticon/plcvyiwmdh4adlt8dxgo.png" width="80px" height="80px"/>		
		</td>
	</tr>
	<tr>
		<td>AWS EC2</td>
		<td>AWS RDS</td>
	</tr>
</table>

## Overview

대중적인 게시판의 기능들을 제작하는 것이 이번 프로젝트의 목표입니다. 게시글 작성과, 댓글 작성, 게시글 마다 “좋아요”를 할 수 있습니다. 게시글 작성은 Notion의 문서 편집 방식을 모방했습니다.
### 인덱스 페이지
![인덱스페이지](https://s3.ap-northeast-2.amazonaws.com/ikiningyou.portfolio.s3.bucket/Images/collaborationBoard/%EC%9D%B8%EB%8D%B1%EC%8A%A4%ED%8E%98%EC%9D%B4%EC%A7%80.png)
### 게시글 목록 페이지
![게시판](https://s3.ap-northeast-2.amazonaws.com/ikiningyou.portfolio.s3.bucket/Images/collaborationBoard/%E1%84%80%E1%85%A6%E1%84%89%E1%85%B5%E1%84%91%E1%85%A1%E1%86%AB.png)
### 게시글 작성 페이지
![글작성페이지](https://s3.ap-northeast-2.amazonaws.com/ikiningyou.portfolio.s3.bucket/Images/collaborationBoard/%E1%84%80%E1%85%B3%E1%86%AF%E1%84%8C%E1%85%A1%E1%86%A8%E1%84%89%E1%85%A5%E1%86%BC%E1%84%91%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%8C%E1%85%B5.png)
### 게시글 댓글
![댓글](https://s3.ap-northeast-2.amazonaws.com/ikiningyou.portfolio.s3.bucket/Images/collaborationBoard/%E1%84%83%E1%85%A2%E1%86%BA%E1%84%80%E1%85%B3%E1%86%AF.png)

## 개발 Story

### Next auth 인증 처리
#### Why

Oauth2 로그인 처리를 Spring boot에서도 할 수 있지만, Next.js에서는 Next auth로 인증 처리를 할 수 있습니다. 백엔드에서 인증처리를 구현해 본 적이 있기 때문에 Next auth를 사용했을 때, 무엇이 다른지 알아보기 위해 Next auth로 인증 처리를 했습니다.

#### How

Next auth의 공식문서를 보면 pages/api/auth에 […nextauth].ts를 추가해서 사용해야 한다고 나와있습니다.

![공식문서](https://s3.ap-northeast-2.amazonaws.com/ikiningyou.portfolio.s3.bucket/Images/collaborationBoard/next+auth+%EC%9D%B8%EC%A6%9D%EC%B2%98%EB%A6%AC/%E1%84%80%E1%85%A9%E1%86%BC%E1%84%89%E1%85%B5%E1%86%A8%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5.png)

\[…nextauth\].ts는 provider, secret, session, callback 등 여러가지 설정에 대한 정보를 가지고 있는 AuthOptions 객체를 매개변수로 NextAuth라는 함수를 export 합니다.

Next auth는 Next.js Server에서 동작하기 때문에 브라우저에서는 인가가 필요한 모든 API 요청은 우선 Next.js Server에 하고 인가가 된 요청들만 Spring boot으로 넘어 가게 됩니다.

로그인 후 API를 요청이 응답을 받기 까지의 과정은 다음과 같습니다.

![요청이 정상적으로 응답을 받기까지의 과정](https://s3.ap-northeast-2.amazonaws.com/ikiningyou.portfolio.s3.bucket/Images/collaborationBoard/next+auth+%EC%9D%B8%EC%A6%9D%EC%B2%98%EB%A6%AC/%E1%84%89%E1%85%B5%E1%84%8F%E1%85%AF%E1%86%AB%E1%84%89%E1%85%B3.png)
> 요청이 정상적으로 응답을 받기까지의 과정

### Notion like 게시글 편집
#### Why

보통의 게시판의 편집이라하면 WYSIWYG(What You See Is What You Get) Editor 형식을 따르고 있습니다.

하지만, 최근 몇 년 간 무언가를 기록할 때 개인적으로 WYSIWYG Editor를 쓴 기억이 거의 없고, Notion이나 iOS 기본 메모 어플을 사용하는 것이 더 편했습니다. 이런 저의 경험을 기반으로 기존의 방식에서 벗어나 Notion 방식의 게시글 편집기를 구현해보기로 했습니다.

여기서 모든 블록에 대한 DOM 관리에 대해서

#### How

Notion의 가장 큰 특징이라고 하면 문장 하나가 하나의 블록처럼 관리할 수 있다는 점이라고 생각합니다.

 > / pages / board / [title] / content / edit.ts


모든 블록의 상태는 Redux의 content라는 객체로 관리하고, content가 업데이트 될 때마다 useMemo를 사용하여 re-rendering합니다.

```tsx
//redux/features/content.ts
interface ContentState {
  contents: ContentBarData[];
  //...
}
//edit.tsx
const contents = useAppSelector(getContents);
const ContentEditBarList = useMemo(() => {

// ...

    return contents.map((value, index) => (
      <ContentEditBar
	// {...props}
      />
    ));
  }, [contents]);
```

여기서 현재의 방식과 DOM 조작으로 업데이트 하는 방식 둘 중 하나를 많이 고민했었습니다.

현재의 방식을 선택한 이유는 DOM 조작은 코드 내에서 어디에 무슨 DOM이 있는 지 파악하기 어렵고, 그렇기에 버그가 생기면 통제가 힘들고, 버그가 생기는 변수도 너무 다양하기 때문에 대체할 수 밖에 없었습니다.

현재 방식으로 구현해서 얻을 수 있는 장점은 어느 위치에 어느 블록이 rendering 되는지 명확하게 알 수 있고, 블록을 생성,수정,삭제하는 과정에서 버그가 발생하지 않을 것이라는 보장을 얻을 수 있습니다.

또한 게시글을 저장할 때, 작성한 게시글 정보는 content 객체를 그대로 가져오면 된다는 장점이 있습니다.

현재 방식의 단점은 re-rendering 과정에서 useMemo를 써도 DOM 조작에 비해 더 많은 re-rendering이 일어나는데, 이로 인해 긴 게시글을 작성할 경우에 느린 동작이 발생할 수 있다는 것입니다.

하지만 유의미하게 느려질 정도의 긴 게시글의 비중이 그렇지 높지 않다고 예상하기 때문에 최종적으로 지금의 방식으로 구현했습니다.

### 게시글 작성 중 이미지 저장 관리
#### Why

- 게시글 작성 중 이미지를 업로드 하면 이미지 서버에 따로 저장되고, 이미지 서버가 응답으로 보내주는 이미지에 대한 URL 사용하는 방식을 사용하고 있었습니다.
- 게시글이 삭제될 때, DB에 저장된 이미지들 정보도 같이 삭제되어야 하는데, 이를 위해서는 게시글의 ID과 이미지의 ID를 JOIN해야 합니다.
- 하지만 게시글의 ID는 게시글이 저장될 때 정해지기 때문에, 저장 전에 발급받는 이미지 ID와 연관을 짓기 위해 게시글을 저장하고, 생성된 게시글 ID을 저장된 이미지들의 ID와 연동하는 작업을 할 필요가 있었습니다.

#### How

우선 `saveContent`로 게시글을 저장한 뒤에, `res.data` 로 등록된 게시글의 ID을 받습니다.

```tsx
// pageas/board/[title]/content/edit.tsx
const handleClickSubmit = (
    e: React.MouseEvent<HTMLInputElement, MouseEvent>
  ) => {
	// ...
      saveContent(data).then((res) => {
				// res.data => 등록된 게시글의 ID
        confirmImages(res.data, images, session.user.id);
      });
	// ...
  };
```

그 다음에 `confirmImages`에서 게시글 ID, 게시글에 등록된 이미지들의 ID, 작성자 ID를

다시 이미지 서버에 전달하고, 이미지 서버에서 이미지를 등록한 사용자와 작성자를 대조한 뒤, 이미지가 저장된 게시글의 ID를 갱신합니다.

### 게시판에서 이미지 크기 처리
#### Why

- next/image는 Local image는 자동으로 width, height를 맞춰주지만 API를 통해 외부에서 받아온 이미지는 따로 크기를 지정해줘야 했습니다.
- 하지만 이미지의 width가 너무 큰 경우에는 일부가 화면을 넘어가는 경우가 생기고, X축 스크롤이 생기는 것이 UX의 관점에서 불편하고 생각했습니다.

![이미지 크기를 따로 조절해주지 않으면 위와 같이 이미지가 화면에 깔끔하게 맞춰지는 것이 아니라, X축에 스크롤이 생깁니다.](https://s3.ap-northeast-2.amazonaws.com/ikiningyou.portfolio.s3.bucket/Images/collaborationBoard/%EA%B2%8C%EC%8B%9C%ED%8C%90%EC%97%90%EC%84%9C+%EC%9D%B4%EB%AF%B8%EC%A7%80+%ED%81%AC%EA%B8%B0+%EC%B2%98%EB%A6%AC/%E1%84%8B%E1%85%B5%E1%84%86%E1%85%B5%E1%84%8C%E1%85%B5%E1%84%8F%E1%85%B3%E1%84%80%E1%85%B5.png)
> 이미지 크기를 따로 조절해주지 않으면 위와 같이 이미지가 화면에 깔끔하게 맞춰지는 것이 아니라, X축에 스크롤이 생깁니다.

- 그렇기 때문에 현재 브라우저의 창의 크기를 이벤트 리스너로 감지하면서 이미지의 원본 크기에 맞춰서 적당한 크기로 맞춰주는 작업을 했습니다.

#### How

- 우선 이미지 서버에서 받은 URL로 이미지를 불러옵니다.

![이미지 최적화 실패](https://s3.ap-northeast-2.amazonaws.com/ikiningyou.portfolio.s3.bucket/Images/collaborationBoard/%EA%B2%8C%EC%8B%9C%ED%8C%90%EC%97%90%EC%84%9C+%EC%9D%B4%EB%AF%B8%EC%A7%80+%ED%81%AC%EA%B8%B0+%EC%B2%98%EB%A6%AC/%EC%9D%B4%EB%AF%B8%EC%A7%80%EB%B6%88%EB%9F%AC%EC%98%A4%EA%B8%B0.png)

- next/Image에서 src의 이미지를 불러왔을때 onLoadingComplete가 동작합니다.

```jsx
<div
      ref={$image}
      className={`${styles.image_box}`}>
      <Image
        onLoadingComplete={onLoadingCompleteHandler}
        src={getImageSrc(authorId, image)}
        alt={NO_IMAGE}
        width={imageSize.width}
        height={imageSize.height}
        unoptimized={true}
        priority={true}
/>
</div>
```

- onLoadingComplete는 decode된 HTMLImageElement를 넘겨주는데, 이를 가지고 이미지의 원본 크기를 저장합니다.

```tsx
const onLoadingCompleteHandler = async (img: HTMLImageElement) => {
    const naturalImageSize: SizeType = getNaturalImageSize(img);
    setNaturalImageSize(naturalImageSize);
  };
```

- 이때, Optimized된 경우에는 아래 이미지처럼 “Example Image”라 적혀있는 text bar 한 줄 높이에 맞춰서 크기를 최적화해버리기 때문에 이를 비활성화해서 이미지를 가져옵니다.

![next/image에서 최적회된 이미지는 natural width, height가 상위 요소의 크기에 맞게 최적화해서 가져오기 때문에 상당히 작게 표시됩니다.](https://s3.ap-northeast-2.amazonaws.com/ikiningyou.portfolio.s3.bucket/Images/collaborationBoard/%EA%B2%8C%EC%8B%9C%ED%8C%90%EC%97%90%EC%84%9C+%EC%9D%B4%EB%AF%B8%EC%A7%80+%ED%81%AC%EA%B8%B0+%EC%B2%98%EB%A6%AC/%EC%9D%B4%EB%AF%B8%EC%A7%80%EC%B5%9C%EC%A0%81%ED%99%94+%EC%8B%A4%ED%8C%A8.png)
> next/image에서 최적회된 이미지는 natural width, height가 상위 요소의 크기에 맞게 최적화해서 가져오기 때문에 상당히 작게 표시됩니다.

- 이후 브라우저 창의 크기가 바뀔때마다 화면에 맞는 크기로 이미지가 resize됩니다.

```jsx
const [imageSize, setImageSize] = useState<SizeType>({
  width: 0,
  height: 0,
});

useEffect(() => {
  const resizedImageSize = getResizedImageSize(
    naturalImageSize,
    $image.current.offsetWidth
  );

  setImageSize(resizedImageSize);
}, [image, windowWidth, naturalImageSize]);
```

### 게시글 작성 기능 구현 중 Props Drilling과 Redux
#### Why

- 게시글을 작성할 때, 입력되는 모든 것은 contents라는 객체에 저장됩니다. contents는 ContentBarData의 객체의 Array 형식입니다.

```tsx
interface ContentBarData {
  type: ContentType;
  content: string;
  image: string;
}
```

- 이 contents를 props로 받는 ContentEditBar는 직접 contents를 쓰지 않고, TextBar나 ImageBar로 다시 props로 넘겨줍니다.
- 그렇기 때문에 Props Drilling이 발생했고, 이를 해결하기로 했습니다.

```jsx
<div
      ref={$wrapper}
      className={`${styles.wrapper}`}
      onClick={handleClickWrapper}
      onMouseMove={handleMouseMoveWrapper}
      onMouseLeave={handleMouseLeave}
      onMouseUp={handleMouseUpWrapper}
>
      {getBarByType(type)}
</div>
```

```tsx
const getBarByType = (type: string) => {
    if (type === ContentTypes.text) {
      return (
	<TextBar
          contents={contents}
	  // ... props
        />
      );
    }
    if (type === ContentTypes.image) {
      return (
	<ImageBar 
		contents={contents}
		// ... props
	/>
	);
    }
  };
```

#### How

Redux의 공식 문서에서는 Redux Toolkit을 사용하는 것을 권장하고 있습니다. 그렇기에 권장사항을 따라서 RTK의 기본 설정을 했습니다.

**RTK 폴더 구조**

> / redux / features / content.ts , hooks.ts , reducer.ts , store.ts


```tsx

interface ContentState {
  contents: ContentBarData[];
}

const initialState: ContentState = {
  contents: [{ type: "text", text: "", image: "" }],
};

export const content = createSlice({
  name: "content",
  initialState,
  reducers: {
    setContents: (state, actions: ContentsActions) => {
	// state.contents = {{ NewContents }} 
    },
    addContent: (state, actions: ContentActions) => {
	// state.contents = [...state.contents, {{ NewContent }}];
    },
    addNewContent: (state, actions: AddNewContentActions) => {
	// state.contents = [ ... , state.contents[index] = {{ NewContent }} , ... ]
    },
    modifyContentByIndex: (state, actions: ModifyByIndexActions) => {
	// state.contents[index] = {{ ModifiedContent }}
    },
    removeContentByIndex: (state, actions: DeleteByIndexActions) => {
	// state.contents filter index !== targetIndex
    },
    resetContents: (state) => {
	// state.contents = {{ initContents }};
    },
    swapElementsSequenceInContents: (state, actions: SwapActions) => {
	// swap state.contents[A], state.contents[B]
  },
});

export const {	/* ... reducers */ } = content.actions;

export const getContent = (state: AppState) => state.content;
export const getContents = (state: AppState) => state.content.contents;

export default content.reducer;
```

### 상수 문자열 관리
#### Why

- 프로젝트 진행 중 Component가 늘어날수록 Component에서 사용하는 상수 문자열이 늘어남에 따라 수정할 때마다 직접 수정하는 것이 번거로워져서 따로 TS 파일에 상수로써 관리할 필요가 있었습니다.
- 긴 문자열을 입력할 때 오탈자가 생기거나, 시간이 조금 더 걸리는 것을 따로 상수로 export 하면 IDE에서 추적, 관리 되기 떄문에 효율적인 개발이 가능해지는 기대를 할 수 있었습니다.

#### How

src/static 폴더를 따로 생성한 뒤에 상수의 타입에 맞춰서 numbers, strings의 폴더를 하위 폴더로 생성했습니다.

> / static / numbers / numberSet.ts
> 	/ strings / HtmlElementId.ts , IconSrc.ts , requestURI.ts , stringSet.ts

다음과 같이 Component에서 사용할 여러가지 문자열들을 상수로 선언해서 여기저기 흩어져있는 문자열들을 한 곳에서 관리할 수 있게 했습니다.

```tsx

export const HTML_HEAD_TITLE = "Collabo Board";

export const HeaderRightMenu = {
  alert: "Alert",
  myPage: "MyPage",
  login: "Login",
  logout: "Logout",
} as const;

export const sizes = "(max-width: 768px) 100vw,(max-width: 1200px) 50vw, 33vw";

export const contentMetaColumns = {
  author: "작성자",
  created: "작성일",
  views: "조회수",
  likes: "좋아요",
};

export const EMPTY_STRING = "";

export const NO_IMAGE = "No Image";

//...이하 생략
```

### Github, commit과 contribution
#### Why

IDE에서 개발을 하고 commit을 하면 그에 맞게 github에서 contribution이 반영되고, 흔히 ‘잔디밭’이라고 불리는 contributions graph에 초록색으로 표시가 됩니다.

하지만 commit을 꾸준히 하면서 정상적으로 초록색으로 표시되는지 확인을 하지 않았기 때문에 contributions graph에 반영이 안 됐었던 것을 파악하지 못했고, 이를 해결하기 위해 이유를 조사했습니다.

![깃허브잔디](https://s3.ap-northeast-2.amazonaws.com/ikiningyou.portfolio.s3.bucket/Images/collaborationBoard/github+commit%EA%B3%BC+contribution/%E1%84%8C%E1%85%A1%E1%86%AB%E1%84%83%E1%85%B5.png)

#### How

Github 공식문서에 나와있는 Missing Contributions에서 **Why are my contributions not showing up on my profile?에서 이유를 알 수 있었습니다.**

![깃허브 공식문서](https://s3.ap-northeast-2.amazonaws.com/ikiningyou.portfolio.s3.bucket/Images/collaborationBoard/github+commit%EA%B3%BC+contribution/%E1%84%80%E1%85%B5%E1%86%BA%E1%84%92%E1%85%A5%E1%84%87%E1%85%B3%E1%84%80%E1%85%A9%E1%86%BC%E1%84%89%E1%85%B5%E1%86%A8%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5.png)

> Commits must be made with an email address that is connected to your account on [GitHub.com](http://GitHub.com) … in order to appear on your contributions graph

즉, contribution을 위해서는 github에 등록된 이메일 주소로 커밋을 해야했습니다.

확인해보니 IDE에서 local repository에 설정된 이메일 주소와 github에 등록된 이메일 주소가 달랐고,

Github에서 제시하는 다음과 같은 방법으로 올바른 이메일로 변경해 문제를 해결할 수 있었습니다.

> $ git config —global user.email “YOUR_EMAIL”

---

## 개발 Docs

### 상태 관리 by redux

- `commentModify`
    
    > 댓글을 수정할 때 한번에 하나의 댓글만 수정할 수 있다는 것을 보장하기 위해 수정 중인 댓글의 index를 저장합니다.
    
    - 구조
        - `modifyIndex` : 현재 수정 중인 댓글의 index
- `content`
    
    > 작성 중인 게시글의 내용한 대한 정보를 저장합니다.
    
    - 구조
        - `contents` : 블록 단위의 내용을 담고 있는 배열
        - `images` : 현재 게시글에 사용된 이미지의 ID를 담고 있는 배열
- `imageHandler`
    
    > 이미지 삭제를 위한 `ImageHandler` 컴포넌트에서 사용되는 상태 값들입니다.
    
    - 구조
        - `imageFocusIndex` : 마우스 포인터가 가르키고 있는 이미지의 index
        - `size` : `imageFocusIndex`가 가르키는 이미지의 크기
        - `position` : `imageFocusIndex`가 가르키는 이미지의 위치
        - `isVisible` : `ImageHandler`의 활성화 여부
- `menuToogle`
    
    > 페이지 왼쪽에 있는 `AppDrawer`가 반응형에 맞춰 on/off 스위칭할 때 사용됩니다.
    
    - 구조
        - `isAppDrawerOpened` : `AppDrawer`를 on/off 상태를 나타내는 flag
- `pageIndex`
    
    > 게시판에서 페이지네이션하기 위한 Page navigator에 사용합니다.
    
    - 구조
        - `index` : `PaginationBar`에서 선택된 index
- `windowWidth`
    
    > 이미지 크기를 조절할 때 사용되는 브라우저의 넓이를 저장합니다.
    
    - 구조
        - `width` : 브라우저의 넓이


### Components

#### Board

- `ContentBar`
    - 게시판의 게시글 목록에서 하나의 게시글의 링크를 가지고 있는 Bar 입니다.
- `ContentList`
    - 게시판 제목와 `ContentBar`목록을 가지고 있는 컨테이너 Component입니다.
- `PaginationBar`
    - 게시글을 페이지네이션으로 불러오는 Component 입니다.

#### Board Content

- `Comment`
    - 댓글 편집기, 목록을 담고 있는 컨테이너 Component 입니다.
- `CommentBar`
    - 하나의 댓글을 표시하는 Bar 입니다.
- `ContentImageViewBar`
    - 게시글에서 이미지 하나를 표시하는 블록입니다.
- `ContentViewBar`
    - 게시글에서 텍스트 하나를 표시하는 블록입니다.

#### Board Content Button

- `CommentDeleteButton`
    - 댓글의 작성자에게만 나타나는 댓글 삭제 버튼입니다.
- `CommentModifyButton`
    - 댓글의 작성자에게만 나타나는 댓글 수정 버튼입니다.
- `ContentDeleteButton`
    - 게시글 작성자에게만 나타나는 게시글 삭제 버튼입니다.
- `ContentModifyButton`
    - 게시글 작성자에게만 나타는 게시글 수정 버튼입니다.
- `LikeButton`
    - 게시글에 있는 좋아요 버튼입니다.

#### Board Content Edit

- `AddTypeModal`
    - 게시글 편집 중 블록 추가 시 텍스트, 이미지 중 하나를 추가하기 위한 Modal 입니다.
- `ContentEditBar`
    - 게시글 편집 페이지에서 하나의 블록을 구성하는 최상위 Component 입니다.
- `ImageBar`
    - `ContentEditBar`에 포함된 이미지를 표시하는 블록입니다.
- `ImageHandler`
    - `ImageBar`의 이미지를 삭제하기 위한 Modal 입니다.
- `TextBar`
    - `ContentEditBar`에 포함된 텍스트를 표시하는 블록입니다.

#### Frame

- `Layout`
    - 페이지의 전체적인 구조를 담고 있는 Layout Component 입니다.
- `AppDrawer`
    - 페이지 왼쪽에 위치한 게시판 메뉴 (`BoardMenu`) Drawer Component 입니다.
- `Header`
    - 페이지 위쪽에 위치한 헤더 Component 입니다.
- `Main`
    - 페이지 내용에 대한 컨테이너 Component 입니다.

#### Frame Menu

- `BoardMenu`
    - 게시판 메뉴들을 가지고 있는 Component 입니다. 반응형으로 `Header`나 `AppDrawer`에 표시됩니다.

---

## 백엔드 API Docs (with Postman)

[백엔드 API Docs](https://documenter.getpostman.com/view/21615276/2s93ecvpoQ)
