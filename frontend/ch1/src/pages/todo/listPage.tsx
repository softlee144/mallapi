import { useSearchParams } from "react-router";
import ListComponent from "../../components/todo/listComponent";

function ListPage() {
  const [queryParams] = useSearchParams();

  // 처음으로 타입스크립트 개념이 나옴
  const page: string | null = queryParams.get("page");
  const size: string | null = queryParams.get("size");

  return (
    <div className="bg-white w-full">
      <div className="text-4xl">
        Todo List Page {page} {size}
        <ListComponent />
      </div>
    </div>
  );
}

export default ListPage;
