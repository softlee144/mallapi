import { useParams } from "react-router";
import ModifyComponent from "../../components/todo/modifyComponent";

function ModifyPage() {
  const { tno } = useParams();

  return (
    <div className="bg-white w-full">
      <div className="text-4xl">Todo Modify Page {tno}</div>
      {/* 타입스크립트라서 Number형 지켜주는 것이 중요 */}
      <ModifyComponent tno={Number(tno)} />
    </div>
  );
}

export default ModifyPage;
